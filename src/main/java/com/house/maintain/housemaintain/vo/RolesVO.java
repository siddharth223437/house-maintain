package com.house.maintain.housemaintain.vo;

import com.house.maintain.housemaintain.vo.enums.RoleEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RolesVO extends Persistent {

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private RoleEnum roleName;

    @ManyToMany
    private Set<UserVO> userVO = new HashSet<>();

    public RoleEnum getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleEnum roleName) {
        this.roleName = roleName;
    }

    public Set<UserVO> getUserVO() {
        return userVO;
    }

    public void addUserVO(UserVO userVO) {
        this.userVO.add(userVO);
    }
}
