package com.house.maintain.housemaintain.repository;

import com.house.maintain.housemaintain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {

     UserVO findByUsername(String username);
     UserVO findByEmail(String email);
}
