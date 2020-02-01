package com.divergents.eco.model.repository;

import com.divergents.eco.model.User;
import com.divergents.eco.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.regex.*;

@Repository
public class VehicleRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    /*
     *
     * Find users by user Id  from the db
     *
     * */

    public int InsertVehicle(String vehicle_num) {

        return jdbcTemplate.update("insert into vehicle(vehicleNumber) " + "values(?)", vehicle_num);
    }

    public boolean isValidVehicleNumber(String vehicle_num) {
        Pattern p1 = Pattern.compile("[a-zA-Z0-9]{2}[-][0-9]{4}");
        Pattern p2 = Pattern.compile("[a-zA-Z0-9]{3}[-][0-9]{4}");


        Matcher m1 = p1.matcher(vehicle_num);
        Matcher m2 = p2.matcher(vehicle_num);

        //return ((m1.find() && m1.group().equals(vehicle_num) ) || (m2.find() && m2.group().equals(vehicle_num) ));
        return true;
    }
}
