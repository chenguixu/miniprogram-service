package com.poetry.service.impl;

import com.poetry.entity.UserPoem;
import com.poetry.mapper.UserPoemMapper;
import com.poetry.service.UserPoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xice
 * @time 2019-09-2019/9/26
 */
@Service
public class UserPoemServiceImpl implements UserPoemService {

    @Autowired
    UserPoemMapper userPoemMapper;

    @Override
    public int insert(UserPoem record) {
        return userPoemMapper.insert(record);
    }

    @Override
    public List<Map<Object, Object>> getUserPoems(Integer status, String openId) {
        return userPoemMapper.getUserPoems(status, openId);
    }

    @Override
    public int pointUserPoem(Integer id) {
        return userPoemMapper.pointUserPoem(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserPoem record) {
        return userPoemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public UserPoem getUserPoemById(Integer id) {
        return userPoemMapper.selectByPrimaryKey(id);
    }
}
