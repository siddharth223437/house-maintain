package com.house.maintain.housemaintain.repository;

import com.house.maintain.housemaintain.vo.AddressVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressVO, Long> {
}
