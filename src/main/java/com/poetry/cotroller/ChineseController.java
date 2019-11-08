package com.poetry.cotroller;
import	java.util.ArrayList;
import	java.util.Random;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poetry.entity.Chinese;
import com.poetry.mapper.ChineseMapper;
import com.poetry.mapper.NickNameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * 汉字查询
 * @author xice
 * @time 2019-10-2019/10/31
 */
@RestController
@RequestMapping("/api/")
public class ChineseController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ChineseMapper chineseMapper;
    @Autowired
    NickNameMapper nickNameMapper;

    /**
     * 获取昵称
     * @param total :要获取的总个数
     * @return
     */
    @GetMapping("getWordForNickname/{total}")
    public String getWordForNickname(@PathVariable("total")Integer total){
        List<String> result = new ArrayList<String> ();
        //查询字库中有多少个字
        int allNum = nickNameMapper.countId();
        for (Integer i = 0; i < total; i++) {
            Random random = new Random();
            //随机昵称的长度
            int len =  random.nextInt(3)+2;
            Integer[] ids = new Integer[len];
            for (int j = 0; j < len; j++) {
                //得到一个随机数，作为查询汉字的id,共有16142字
                ids[j] = random.nextInt(allNum)+1;
            }
//            根据id获取汉字
            List<String> words = nickNameMapper.getWordsByIds(ids);
            String name = "";
            for (String word : words) {
                name+=word;
            }
            result.add("\""+name+"\"");
        }
        return result.toString();
    }


    @PostMapping("getChineseByPage")
    public PageInfo<Chinese> getChineseByPage(@RequestParam("page")Integer page,@RequestParam("size")Integer size,
                                              @RequestParam(value="key",required =false)String key){
        PageInfo<Chinese> pageInfo = null;
        if(page<1){
            page = 1;
        }
        if(size>50){
            size = 50;
        }else if(size<1){
            size = 1;
        }
        PageHelper.startPage(page,size);
        List<Chinese> list = chineseMapper.getChineseByPage(key);
        pageInfo = new PageInfo <Chinese>(list);
        return pageInfo;
    }
}
