package com.poetry.cotroller;
import	java.util.Date;
import	java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poetry.entity.PoemComment;
import com.poetry.entity.UserPoem;
import com.poetry.mapper.UserPoemCommentMapper;
import com.poetry.service.UserPoemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author xice
 * @time 2019-09-2019/9/26
 */
@RestController
@RequestMapping("api/userpoem")
public class UserPoemController {
    private final  static Logger logger = LoggerFactory.getLogger(UserPoemController.class);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private UserPoemService userPoemService;
    @Autowired
    private UserPoemCommentMapper userPoemCommentMapper;

    /**
     * 用户发表诗词
     * @param title
     * @param poem
     * @param author
     * @param openId
     * @return
     */
    @PostMapping("issuePoem")
    public int issueNewPoem(@RequestParam("title")String title,@RequestParam("poem")String poem,
                            @RequestParam("author")String author,@RequestParam("openId")String openId){
        UserPoem userPoem = new UserPoem();
        userPoem.setTitle(title);
        userPoem.setAuthor(author);
        userPoem.setOpenId(openId);
        userPoem.setUserPoem(poem);
        userPoem.setIssueTime(dateFormat.format(new Date()));
        userPoem.setStatus(1);//审核中
        int result = userPoemService.insert(userPoem);
        return result;
    }

    /**
     * 查看用户发布的诗词
     * @param openId
     * @param status
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("getUserPoems")
    public PageInfo<Map<Object, Object>> getUserPoem(@RequestParam(value="openId",required = false)String openId,
                                          @RequestParam("status")Integer status,@RequestParam("page")Integer page,
                                          @RequestParam("size")Integer size){
        if(size<1){
            size=1;
        }else if(size>50){
            size=50;
        }
        logger.info("openId="+openId);
        PageHelper.startPage(page,size);
        List<Map<Object, Object>> userPoems = userPoemService.getUserPoems(status,openId);
        PageInfo<Map<Object, Object>> pageInfo = new PageInfo<Map<Object, Object>> (userPoems);
        return pageInfo;
    }


    /**
     * 给指定的用户诗词点赞
     * @param id
     * @return
     */
    @GetMapping("pointUserPoem/{id}")
    public int pointUserPoem(@PathVariable("id")Integer id){
        return userPoemService.pointUserPoem(id);
    }

    /**
     * 发布评论
     * @param poemId
     * @param openId
     * @param comment
     * @return
     */
    @PostMapping("issueUserComment")
    public int commentPoem(@RequestParam("poemId") Integer poemId,@RequestParam("openId") String openId
            ,@RequestParam("comment")String comment){
        PoemComment c = new PoemComment();
        c.setOpenId(openId);
        c.setPoemId(poemId);
        c.setComment(comment);
        c.setCommentTime(dateFormat.format(new Date()));
        return userPoemCommentMapper.insertSelective(c);
    }

    /**
     * 获取评论
     * @param poemid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("getUserPomeComments/{poemid}/{page}/{size}")
    public PageInfo<PoemComment> getPomeComments(@PathVariable("poemid") Integer poemid, @PathVariable("page") Integer page
            , @PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<PoemComment> poemComments = userPoemCommentMapper.getPoemComments(poemid);
        PageInfo<PoemComment> pageInfo = new PageInfo<PoemComment>(poemComments);
        return pageInfo;
    }

    /**
     * 审核用户诗词
     * @param poemid
     * @param status
     * @return
     */
    @GetMapping("approveUserPoem/{poemid}/{status}")
    public int approveUserPoem(@PathVariable("poemid") Integer poemid, @PathVariable("status")Integer status ){
        UserPoem userPoem = new UserPoem();
        userPoem.setId(poemid);
        userPoem.setStatus(status);
        return userPoemService.updateByPrimaryKeySelective(userPoem);
    }

    @GetMapping("getUserPoemById/{id}")
    public UserPoem getUserPoemById(@PathVariable("id")Integer id){
        return userPoemService.getUserPoemById(id);
    }
}
