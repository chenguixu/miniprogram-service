package com.poetry.mapper;

import com.poetry.entity.NickName;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NickNameMapper {
    int insert(NickName record);

    int insertSelective(NickName record);

    List<String> getWordsByIds(@Param("ids") Integer[] ids);

    int countId();
}