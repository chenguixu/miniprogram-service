package com.poetry.mapper;
import	java.util.List;
import java.util.Map;

import com.poetry.entity.UserPoem;
import org.apache.ibatis.annotations.Param;

public interface UserPoemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPoem record);

    int insertSelective(UserPoem record);

    UserPoem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPoem record);

    int updateByPrimaryKey(UserPoem record);

//  根据诗的状态获取列表，当有openId时表明要获取指定人的
    List <Map<Object, Object>> getUserPoems(@Param("status") Integer status, @Param("openId")String openId);
    //  点赞指定的诗
    int pointUserPoem(Integer id);
}