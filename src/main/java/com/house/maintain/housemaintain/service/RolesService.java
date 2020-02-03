package com.house.maintain.housemaintain.service;

import com.house.maintain.housemaintain.util.DaoServiceUtil;
import com.house.maintain.housemaintain.vo.RolesVO;
import com.house.maintain.housemaintain.vo.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    @Autowired
    private DaoServiceUtil daoServiceUtil;

    public boolean addNewRoles(RoleEnum roleEnum){
        try{
            RolesVO rolesVO = new RolesVO();
            rolesVO.setRoleName(roleEnum);
            daoServiceUtil.rolesRepository.save(rolesVO);
            return true;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
