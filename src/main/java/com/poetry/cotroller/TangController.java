package com.poetry.cotroller;
import	java.lang.reflect.Parameter;
import	java.awt.print.Pageable;
import	java.security.Policy;
import	java.util.Date;
import	java.text.SimpleDateFormat;
import	java.util.List;
import	java.lang.ref.Reference;
import	java.util.HashMap;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poetry.entity.PoemComment;
import com.poetry.entity.Poet;
import com.poetry.entity.Tang;
import com.poetry.mapper.PoemCommentMapper;
import com.poetry.service.PoetService;
import com.poetry.service.TangService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 唐诗相关操作
 * @author xice
 * @time 2019-08-2019/8/14
 */
@RestController
@Api(tags = "poetry of the Tang Dynasty")
@RequestMapping("api/poem")
public class TangController {
    private static final Logger log = LoggerFactory.getLogger(TangController.class);
    @Autowired
    TangService tangService;
    @Autowired
    PoetService poetService;
    @Autowired
    PoemCommentMapper poemCommentMapper;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 根据id查看唐诗
     * @param id
     * @return
     */
    @GetMapping("getPoemById/{id}")
    @ResponseBody
    @ApiOperation("根据id查看唐诗")
    @ApiImplicitParam(name="id",value="唐诗id",defaultValue = "1",
            required = true,dataType = "Integer",paramType = "path")
    public Tang getPoemById(@PathVariable("id") Integer id){
        Tang tang = tangService.selectByPrimaryKey(id);
        return tang;
    }

    @GetMapping("getAllPoemByPage/{page}/{size}")
    @ResponseBody
    @ApiOperation("分页查看所有唐诗，每页50首")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码数",defaultValue = "1",required = true,dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name="size",value="每页条数，最多50",defaultValue = "50",required = true,dataType = "Integer",paramType = "path")
        }
    )
    public PageInfo<Tang> getAllPoem(@PathVariable("page") String page,@PathVariable("size") String size){
        int s = Integer.parseInt(size);
        if(s>50){
            s = 50;
        }else if(s<=0){
            s = 50;
        }
        PageHelper.startPage(Integer.parseInt(page),s);
        List<Tang> tangs = tangService.getAllTangListByPage();
        PageInfo<Tang> pageInfo = new PageInfo<Tang> (tangs);
        return  pageInfo;
    }

    /**
     * 根据页码和关键字搜索唐诗
     * @return
     */
    @PostMapping("getPoemByPageAndKey")
    public PageInfo<Tang> getPoemByPageAndKey(HttpServletRequest request){
        PageInfo<Tang> pageInfo = null;
        int pageNum = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
        int pageSize = request.getParameter("size")==null?1:Integer.parseInt(request.getParameter("size"));
        String keyWord = request.getParameter("keyWord");
        log.info("pageNum="+pageNum+",pageSize="+pageSize+",keyWord="+keyWord);
        //先查看诗人
        if (("").equals(keyWord)||keyWord==null){//没有关键字
            log.info("没有关键字");
            PageHelper.startPage(pageNum,pageSize);
            List<Tang> poemByPageAndKey = tangService.getPoemByPageAndKey(keyWord);
            pageInfo = new PageInfo<Tang>(poemByPageAndKey);
        }else {
            List<Poet> poets = poetService.getPoetByName(keyWord);
            if (poets.size() > 0) {//关键词搜索的是诗人
                log.info("关键词搜索的是诗人");
                Poet p = poets.get(0);//获取诗人编码
                PageHelper.startPage(pageNum, pageSize);
                List<Tang> poemByPageAndKey = tangService.getPoemByPoetNum(p.getNum());
                pageInfo = new PageInfo<Tang>(poemByPageAndKey);
            } else {//关键词是诗句
                log.info("关键词是诗句");
                PageHelper.startPage(pageNum, pageSize);
                List<Tang> poemByPageAndKey = tangService.getPoemByPageAndKey(keyWord);
                pageInfo = new PageInfo<Tang>(poemByPageAndKey);
            }
        }
        return pageInfo;
    }
    /**
     * 根据诗人编码获取唐诗
     * @param num
     * @return
     */
    @GetMapping("getPoemByPoetNum/{num}")
    @ApiOperation("根据诗人编码获取唐诗")
    @ApiImplicitParam(name="num",value="诗人编码",defaultValue = "P00001",required = true,dataType = "String",paramType = "path")
    public List<Tang> getPoemByPoetNum(@PathVariable("num") String num){
        System.out.println(num);
        List<Tang> tangs = tangService.getPoemByPoetNum(num);
        return tangs;
    }

    @PostMapping("getPoemInfo")
    public PageInfo<HashMap<Object,Object>> getPoemInfo(HttpServletRequest request){
        PageInfo<HashMap<Object,Object>> pageInfo = null;
        int pageNum = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
        int pageSize = request.getParameter("size")==null?1:Integer.parseInt(request.getParameter("size"));
        String keyWord = request.getParameter("keyWord");
        log.info("pageNum="+pageNum+",pageSize="+pageSize+",keyWord="+keyWord);

        //先查看诗人
        if (("").equals(keyWord)||keyWord==null){//没有关键字
            log.info("没有关键字");
            PageHelper.startPage(pageNum,pageSize);
            List<HashMap<Object,Object>> poemByPageAndKey = tangService.getTangInfoListByPage(keyWord);
            pageInfo = new PageInfo<HashMap<Object,Object>>(poemByPageAndKey);
            log.info("pageInfo="+pageInfo);
        }else {
            List<Poet> poets = poetService.getPoetByName(keyWord);
            if (poets.size() > 0) {//关键词搜索的是诗人
                log.info("关键词搜索的是诗人");
                Poet p = poets.get(0);//获取诗人编码
                PageHelper.startPage(pageNum, pageSize);
                List<HashMap<Object,Object>> poemByPageAndKey = tangService.getPoemInfoByPoetNum(p.getNum());
                pageInfo = new PageInfo<HashMap<Object,Object>>(poemByPageAndKey);
            } else {//关键词是诗句
                log.info("关键词是诗句");
                PageHelper.startPage(pageNum, pageSize);
                List<HashMap<Object,Object>> poemByPageAndKey = tangService.getTangInfoListByPage(keyWord);
                pageInfo = new PageInfo<HashMap<Object,Object>>(poemByPageAndKey);
            }
        }

        return pageInfo;
    }

    /**
     * 点赞指定id的诗
     * @param id
     * @return
     */
    @GetMapping("/pointPoem/{id}")
    public int pointPoem(@PathVariable("id")Integer id){
        return tangService.pointPoem(id);
    }

    /**
     * 发布评论
     * @param poemId
     * @param openId
     * @param comment
     * @return
     */
    @PostMapping("/issueComment")
    public int commentPoem(@RequestParam("poemId") Integer poemId,@RequestParam("openId") String openId
    ,@RequestParam("comment")String comment){
        PoemComment c = new PoemComment();
        c.setOpenId(openId);
        c.setPoemId(poemId);
        c.setComment(comment);
        c.setCommentTime(dateFormat.format(new Date()));
        return poemCommentMapper.insertSelective(c);
    }

    /**
     * 获取评论
     * @param poemid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/getPomeComments/{poemid}/{page}/{size}")
    public PageInfo<PoemComment> getPomeComments(@PathVariable("poemid") Integer poemid,@PathVariable("page") Integer page
            ,@PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<PoemComment> poemComments = poemCommentMapper.getPoemComments(poemid);
        PageInfo<PoemComment> pageInfo = new PageInfo<PoemComment>(poemComments);
        return pageInfo;
    }

    @GetMapping("notice")
    public String getNotice(){
        return "诗词酒馆小程序隆重上线，欢迎使用！";
    }
}
