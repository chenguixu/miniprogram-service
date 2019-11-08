package com.poetry.mapper;

import com.poetry.entity.PoemUser;

public interface PoemUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoemUser record);

    int insertSelective(PoemUser record);

    PoemUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoemUser record);

    int updateByPrimaryKey(PoemUser record);

     //根据openid查询
    int selectByOpenId(String openId);

    PoemUser selectInfoByOpenId(String openId);

    String getUserAvatarByOpenId(String openId);
}