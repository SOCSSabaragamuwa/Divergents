package com.divergents.eco.service;

import com.divergents.eco.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
 /*
 *
 * Find users by user Id  from the db
 *
 * */

    public User findById(int id) {
        return jdbcTemplate.queryForObject("select * from user where user_id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< User >(User.class));
    }


}
