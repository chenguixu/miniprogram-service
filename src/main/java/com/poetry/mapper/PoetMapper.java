package com.poetry.mapper;

import com.poetry.entity.Poet;

import java.util.List;

public interface PoetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Poet record);

    int insertSelective(Poet record);

    Poet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Poet record);

    int updateByPrimaryKey(Poet record);

    String selectPoetNumByName(String name);

    String getPoetNameByNum(String num);

    List<Poet> getPoetByName(String name);

    Poet getPoetByNum(String num);

}