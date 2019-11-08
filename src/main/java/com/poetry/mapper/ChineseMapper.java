package com.poetry.mapper;

import com.poetry.entity.Chinese;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChineseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chinese record);

    int insertSelective(Chinese record);

    Chinese selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chinese record);

    int updateByPrimaryKey(Chinese record);

    List<String> getWordsByIds(@Param("ids") Integer[] ids);

    List<Chinese> getChineseByPage(@Param("key") String key);
}