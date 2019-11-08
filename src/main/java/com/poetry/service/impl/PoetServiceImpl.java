package com.poetry.service.impl;

import com.poetry.entity.Poet;
import com.poetry.mapper.PoetMapper;
import com.poetry.service.PoetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xice
 * @time 2019-08-2019/8/29
 */
@Service
public class PoetServiceImpl implements PoetService {
    @Autowired
    private PoetMapper poetMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Poet record) {
        return 0;
    }

    @Override
    public int insertSelective(Poet record) {
        return 0;
    }

    @Override
    public Poet selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Poet record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Poet record) {
        return 0;
    }

    @Override
    public String selectPoetNumByName(String name) {
        return null;
    }

    @Override
    public List<Poet> getPoetByName(String name) {
        return poetMapper.getPoetByName(name);
    }

    @Override
    public Poet getPoetByNum(String num) {
        return null;
    }
}
