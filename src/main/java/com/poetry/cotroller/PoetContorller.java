package com.poetry.cotroller;

import com.poetry.entity.Poet;
import com.poetry.mapper.PoetMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.util.List;

/**
 * 诗人相关
 * @author xice
 * @time 2019-08-2019/8/16
 */
@RestController
@Api(tags = "poet")
@RequestMapping("api/poet")
public class PoetContorller {
    @Autowired
    PoetMapper poetMapper;

    @GetMapping("getPoetByName/{name}")
    @ApiOperation("根据诗人姓名获取诗人信息")
    @ApiImplicitParam(name = "name",value = "诗人姓名",defaultValue = "李白",required = true,dataType = "String",paramType = "path")
    public List<Poet> getPoetByName(@PathVariable("name") String name){
//        poetMapper.getPoetByName(name);
        return poetMapper.getPoetByName(name);
    }

    @GetMapping("getPoetByNum/{num}")
    @ApiOperation("根据诗人编码获取诗人信息")
    @ApiImplicitParam(name = "num",value = "诗人编码",defaultValue = "P00001",required = true,dataType = "String",paramType = "path")
    public Poet getPoetByNum(@PathVariable("num") String num){
//        poetMapper.getPoetByName(num);
        return poetMapper.getPoetByNum(num);
    }
}
