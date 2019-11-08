package com.poetry.mapper;
import	java.util.HashMap;

import com.poetry.entity.Tang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tang record);

    int insertSelective(Tang record);

    Tang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tang record);

    int updateByPrimaryKey(Tang record);

    //分页获取唐诗
    List<Tang> getAllTangListByPage();
    //根据诗人编码获取唐诗
    List<Tang> getPoemByPoetNum(String num);
    //根据关键字，分页获取唐诗
    List<Tang>  getPoemByPageAndKey(@Param("keyWord") String keyWord);

    //只获取需要展示的信息
    List<HashMap < Object, Object>> getTangInfoListByPage(@Param("keyWord") String keyWord);
    List<HashMap < Object, Object>> getPoemInfoByPoetNum(String num);

//    点赞指定的诗
    int pointPoem(Integer id);
}