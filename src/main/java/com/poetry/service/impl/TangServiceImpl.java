package com.poetry.service.impl;

import com.poetry.entity.Tang;
import com.poetry.mapper.TangMapper;
import com.poetry.service.TangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author xice
 * @time 2019-08-2019/8/29
 */
@Service
public class TangServiceImpl implements TangService {
    @Autowired
    private TangMapper tangMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Tang record) {
        return 0;
    }

    @Override
    public int insertSelective(Tang record) {
        return 0;
    }

    @Override
    public Tang selectByPrimaryKey(Integer id) {
        return tangMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Tang record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Tang record) {
        return 0;
    }

    @Override
    public List<Tang> getAllTangListByPage() {
        return tangMapper.getAllTangListByPage();
    }

    @Override
    public List<Tang> getPoemByPoetNum(String num) {
        return tangMapper.getPoemByPoetNum(num);
    }

    @Override
    public List<Tang> getPoemByPageAndKey(String keyWord) {
        return tangMapper.getPoemByPageAndKey(keyWord);
    }

    @Override
    public List<HashMap<Object, Object>> getTangInfoListByPage(String keyWord) {
        return tangMapper.getTangInfoListByPage(keyWord);
    }

    @Override
    public List<HashMap<Object, Object>> getPoemInfoByPoetNum(String num) {
        return tangMapper.getPoemInfoByPoetNum(num);
    }

    @Override
    public int pointPoem(Integer id) {
        return tangMapper.pointPoem(id);
    }
}
