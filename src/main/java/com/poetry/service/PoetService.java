package com.poetry.service;

import com.poetry.entity.Poet;

import java.util.List;

/**
 * @author xice
 * @time 2019-08-2019/8/29
 */
public interface PoetService {
    int deleteByPrimaryKey(Integer id);

    int insert(Poet record);

    int insertSelective(Poet record);

    Poet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Poet record);

    int updateByPrimaryKey(Poet record);

    String selectPoetNumByName(String name);

    List<Poet> getPoetByName(String name);

    Poet getPoetByNum(String num);
}
