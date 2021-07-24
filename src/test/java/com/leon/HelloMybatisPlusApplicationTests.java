package com.leon;

import com.leon.entity.User;
import com.leon.mapper.UserMapper;
import com.leon.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HelloMybatisPlusApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void queryAll() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    /**
     * 新增
     */
    @Test
    void insert() {
        User user = new User();
        user.setName("leon");
        System.out.println(userMapper.insert(user));
    }

    /**
     * 批量新增
     */
    @Test
    void saveBatch() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(
                    User.builder()
                            .name("用户" + i)
                            .age(i)
                            .build()
            );
        }
        System.out.println(userService.saveBatch(userList));
    }

    /**
     * 删除
     */
    @Test
    void deleteById() {
        System.out.println(userMapper.deleteById("1418871984780226561"));
    }

    /**
     * 批量删除
     */
    @Test
    void deleteBatchIds() {
        System.out.println(userMapper.deleteBatchIds(Arrays.asList("1418871984780226561", "1418872287160238081")));
    }

    /**
     * 修改
     */
    @Test
    void update() {
        User user = userMapper.selectById("1418872287160238081");
        user.setName("testUpdate");
        user.setAka("testUpdate");
        System.out.println(userMapper.updateById(user));
    }


}
