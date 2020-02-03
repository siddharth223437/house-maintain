package com.house.maintain.housemaintain.controller;

import com.house.maintain.housemaintain.dto.UserDto;
import com.house.maintain.housemaintain.util.DaoServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private DaoServiceUtil daoServiceUtil;

    @PostMapping("/role/add")
    public boolean addNewRole(@RequestBody UserDto userDto){
        if(userDto!= null) {
            return daoServiceUtil.rolesService.addNewRoles(userDto.getRoleName());
        }
        return false;
    }

    @PostMapping("/user/add")
    public boolean addNewUser(@RequestBody UserDto userDto){
        daoServiceUtil.userService.addNewUser(userDto);
        return false;
    }
}
