package com.poetry.service;

import com.poetry.entity.UserPoem;

import java.util.List;
import java.util.Map;

/**
 * @author xice
 * @time 2019-09-2019/9/26
 */
public interface UserPoemService {

//    新增诗词
    int insert(UserPoem record);

    //  根据诗的状态获取列表，当有openId时表明要获取指定人的
    List<Map<Object, Object>> getUserPoems(Integer status, String openId);

    //  点赞指定的诗
    int pointUserPoem(Integer id);

    //更新用户诗词指定字段，目前主要用作审核
    int updateByPrimaryKeySelective(UserPoem record);

    UserPoem getUserPoemById(Integer id);
}
