package com.leon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leon.entity.User;
import com.leon.mapper.UserMapper;
import com.leon.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public boolean saveBatch(Collection<User> entityList, int batchSize) {
        return super.saveBatch(entityList, batchSize);
    }
}
