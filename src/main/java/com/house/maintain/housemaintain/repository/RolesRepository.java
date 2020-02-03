package com.house.maintain.housemaintain.repository;

import com.house.maintain.housemaintain.vo.RolesVO;
import com.house.maintain.housemaintain.vo.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesVO, Long> {

    RolesVO findByRoleName(RoleEnum roleName);
}
