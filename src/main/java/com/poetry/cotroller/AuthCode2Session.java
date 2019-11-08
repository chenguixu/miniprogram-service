package com.poetry.cotroller;

import com.alibaba.fastjson.JSONObject;
import com.poetry.entity.PoemUser;
import com.poetry.mapper.PoemUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 微信小程序获取用户信息的方法
 * 只能通过后端调用，不能在小程序内调用
 * @author xice
 * @time 2019-09-2019/9/17
 */
@RestController
@RequestMapping("/api/poem")
public class AuthCode2Session {

    private static Logger log = LoggerFactory.getLogger(AuthCode2Session.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PoemUserMapper poemUserMapper;

    @PostMapping("/AuthCode2Session")
    public String getUserOpenId(@RequestParam("code") String code,@RequestParam("nickName") String nickName,
                                @RequestParam("avatarUrl") String avatarUrl){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx9f414a5317d1aced&secret=e66b25af158f0bc2c564e72a73e34bd5&js_code=" + code
                +"&grant_type=authorization_code";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String strbody = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        JSONObject jsonObject = JSONObject.parseObject(strbody);
        log.info("strbody="+strbody);
        String openid  = jsonObject.getString("openid");
        log.info("openid="+openid);

        //将用户信息保存到数据库
        //先校验此用户是否存在
//        int countId = poemUserMapper.selectByOpenId(openid);
        PoemUser poemUser = poemUserMapper.selectInfoByOpenId(openid);

        if(poemUser==null){
            PoemUser user = new PoemUser();
            user.setOpenId(openid);
            user.setNickName(nickName);
            user.setAvatarUrl(avatarUrl);
            poemUserMapper.insertSelective(user);
        }else{
            boolean isNotSame = false;
            if(!poemUser.getNickName().equals(nickName)){
                poemUser.setNickName(nickName);
                isNotSame = true;
            }
            if(!poemUser.getAvatarUrl().equals(avatarUrl)){
                poemUser.setAvatarUrl(avatarUrl);
                isNotSame = true;
            }
            if(isNotSame){
                poemUserMapper.updateByPrimaryKey(poemUser);
            }
        }
        return openid;
    }
}
