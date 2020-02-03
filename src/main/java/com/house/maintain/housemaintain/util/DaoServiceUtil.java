package com.house.maintain.housemaintain.util;

import com.house.maintain.housemaintain.repository.AddressRepository;
import com.house.maintain.housemaintain.repository.RolesRepository;
import com.house.maintain.housemaintain.repository.UserRepository;
import com.house.maintain.housemaintain.service.RolesService;
import com.house.maintain.housemaintain.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoServiceUtil {

    // repositories
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RolesRepository rolesRepository;
    @Autowired
    public AddressRepository addressRepository;


    // services

    @Autowired
    public RolesService rolesService;
    @Autowired
    public UserService userService;

    //other
    @Autowired
    public Mapper mapper;
}
