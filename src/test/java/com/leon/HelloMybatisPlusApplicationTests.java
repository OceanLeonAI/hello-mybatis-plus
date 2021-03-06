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
    void selectList() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    /**
     * 新增
     */
    @Test
    void insert() {
        User user = new User();
        user.setName("leon");
        System.out.println("新增前 user ---> " + user);
        System.out.println(userMapper.insert(user));
        System.out.println("新增后 user ---> " + user);
    }

    /**
     * 批量新增
     */
    @Test
    void saveBatch() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
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
        System.out.println(userMapper.deleteById("1418964431543787522"));
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
        User user = userMapper.selectById("1418881918146269186");
        user.setName("testUpdate");
//        user.setAka("testUpdate");
        System.out.println(userMapper.updateById(user));
    }

    /**
     * 乐观锁
     */
    @Test
    void testOptimisticLockerInnerInterceptor() {
        // update user ... version = 3 where version = 2
        User user1 = userMapper.selectById("1418888364506263553");
        user1.setName("user1-竞争锁-成功");

        // update user ... version = 3 where version = 2

        User user2 = userMapper.selectById("1418888364506263553");
        user2.setName("user2-竞争锁-成功");

        // FIXME: 此处模拟多线程竞争有缺陷
        System.out.println(userMapper.updateById(user1));
        System.out.println(userMapper.updateById(user2));
    }


}
