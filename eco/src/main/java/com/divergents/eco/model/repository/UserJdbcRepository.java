package com.divergents.eco.model.repository;

import com.divergents.eco.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return jdbcTemplate.queryForObject("select * from user where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< User >(User.class));
    }

    public int addUser(User user) {
        return jdbcTemplate.update("INSERT INTO user (nic, mobile,password) VALUES (?, ?, ?)", user.getNic(),user.getMobile(),user.getPassword());
    }

    public User findByNic(String nic) {
        return jdbcTemplate.queryForObject("select * from user where nic=?", new Object[] {
                        nic
                },
                new BeanPropertyRowMapper< User >(User.class));
    }

    public List<User> findAll() {

        String sql = "SELECT * FROM user";

        List<User> users = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper< User >(User.class));

        return users;

    }

}
