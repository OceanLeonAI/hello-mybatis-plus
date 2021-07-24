package com.leon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leon.mapper.UserMapper;
import com.leon.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class QueryTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有
     */
    @Test
    void selectList() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    /**
     * 多条件等值查询
     */
    @Test
    void multiEqQuery() {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Object> map = new HashMap();
        map.put("name", "用户1");
        map.put("age", 1);
        queryWrapper.allEq(map);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    /**
     * 多条件等值查询
     */
    @Test
    void singleQuery() {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Object> map = new HashMap();
        map.put("name", "用户1");
        map.put("age", 1);
        queryWrapper.allEq(map);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

}
