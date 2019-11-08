package com.poetry.mapper;

import com.poetry.entity.PoemComment;

import java.util.List;

public interface UserPoemCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoemComment record);

    int insertSelective(PoemComment record);

    PoemComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoemComment record);

    int updateByPrimaryKey(PoemComment record);

    int countComment(Integer poemId);

    List<PoemComment> getPoemComments(int poemId);
}