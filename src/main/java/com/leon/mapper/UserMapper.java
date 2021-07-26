package com.leon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leon.entity.ProductVO;
import com.leon.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 创建 Mapper
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 多表关联查询
     *
     * @param id
     * @return
     */
    @Select("SELECT\n" +
            "\tu.`name` userName,\n" +
            "\tp.* \n" +
            "FROM\n" +
            "\tproduct p,\n" +
            "\tUSER u \n" +
            "WHERE\n" +
            "\tu.id = p.user_id \n" +
            "\tAND u.id = #{id}")
    List<ProductVO> productList(Long id);
}
