package com.poetry.service;

import com.poetry.entity.Tang;

import java.util.HashMap;
import java.util.List;

/**
 * @author xice
 * @time 2019-08-2019/8/29
 */
public interface TangService {
    int deleteByPrimaryKey(Integer id);

    int insert(Tang record);

    int insertSelective(Tang record);

    Tang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tang record);

    int updateByPrimaryKey(Tang record);

    List<Tang> getAllTangListByPage();
    //根据诗人编码获取唐诗
    List<Tang> getPoemByPoetNum(String num);
    //根据关键字，分页获取唐诗
    List<Tang>  getPoemByPageAndKey(String keyWord);

    List<HashMap< Object, Object>> getTangInfoListByPage(String keyWord);
    List<HashMap < Object, Object>> getPoemInfoByPoetNum(String num);

    //    点赞指定的诗
    int pointPoem(Integer id);
}
