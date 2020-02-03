package com.house.maintain.housemaintain.service;

import com.house.maintain.housemaintain.dto.UserDto;
import com.house.maintain.housemaintain.util.DaoServiceUtil;
import com.house.maintain.housemaintain.vo.AddressVO;
import com.house.maintain.housemaintain.vo.RolesVO;
import com.house.maintain.housemaintain.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private DaoServiceUtil daoServiceUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean addNewUser(UserDto userDto){
        RolesVO rolesVO = daoServiceUtil.rolesRepository.findByRoleName(userDto.getRoleName());
        if(daoServiceUtil.userRepository.findByUsername(userDto.getUsername()) == null && daoServiceUtil.userRepository.findByEmail(userDto.getEmail()) == null && rolesVO != null){
            UserVO userVO = daoServiceUtil.mapper.map(userDto, UserVO.class);
            AddressVO addressVO = daoServiceUtil.mapper.map(userDto,AddressVO.class);
            if(userVO !=null && addressVO != null){
                userVO.setPassword(passwordEncoder.encode(userDto.getPassword()));
                userVO.setAddressVO(addressVO);
                addressVO.setUserVO(userVO);
                userVO.addRolesVO(rolesVO);
                rolesVO.addUserVO(userVO);
                daoServiceUtil.userRepository.save(userVO);
                return true;
            }
        }

        return false;
    }
}
