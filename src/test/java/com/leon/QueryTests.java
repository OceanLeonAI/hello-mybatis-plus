package com.leon;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leon.entity.User;
import com.leon.mapper.UserMapper;
import com.leon.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@Slf4j
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
        System.out.println("selectList ---> ");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
        System.out.println("selectMaps ---> ");
        userMapper.selectMaps(queryWrapper).forEach(System.out::println);
        System.out.println("selectOne ---> ");
        System.out.println(userMapper.selectOne(queryWrapper));
        System.out.println("selectObjs ---> ");
        userMapper.selectObjs(queryWrapper).forEach(System.out::println);
    }

    /**
     * 模糊查询
     */
    @Test
    void likeQuery() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeLeft("name", "on");
        System.out.println("likeLeft ---> ");
        userMapper.selectList(queryWrapper).forEach(System.out::println);

        queryWrapper = new QueryWrapper();

        queryWrapper.likeRight("name", "le");
        System.out.println("likeRight ---> ");
        userMapper.selectList(queryWrapper).forEach(System.out::println);

        queryWrapper = new QueryWrapper();

        queryWrapper.like("name", "户");
        System.out.println("like ---> ");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    /**
     * 模糊查询
     */
    @Test
    void inSqlQuery() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.inSql("id", "select id from user where id <= 1418964431724142595");
        System.out.println("likeLeft ---> ");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    /**
     * 返回 List 后者 Map
     */
    @Test
    void selectDifferentTypeList() {
        QueryWrapper queryWrapper = new QueryWrapper(null);

        System.out.println("selectList ---> ");
        userMapper.selectList(queryWrapper).forEach(System.out::println);

        System.out.println("selectMaps ---> ");
        userMapper.selectMaps(queryWrapper).forEach(System.out::println);
    }

    /**
     * 分页查询
     */
    @Test
    void selectPage() {
        System.out.println("selectPage ---> ");
        Page<User> page = new Page<>(0, 10);
        Page result = userMapper.selectPage(page, null);
        System.out.println("total ---> " + result.getTotal());
        System.out.println("size ---> " + result.getSize());
        System.out.println("records ---> " + result.getRecords());

        System.out.println("========================");

        IPage<Map<String, Object>> pageMap = new Page<>();
        IPage<Map<String, Object>> mapsPage = userMapper.selectMapsPage(pageMap, null);
        System.out.println("total ---> " + mapsPage.getTotal());
        System.out.println("size ---> " + mapsPage.getSize());
        System.out.println("records ---> " + mapsPage.getRecords());

        // 获取所有的主键集合
        userMapper.selectObjs(null).stream().skip(98).forEach(System.out::println);
    }

    /**
     * 多表联合查询
     */
    @Test
    void unionQuery() {
        userMapper.productList(1419612758509715457L).forEach(System.out::println);
    }


}
