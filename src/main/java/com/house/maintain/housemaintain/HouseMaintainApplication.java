package com.house.maintain.housemaintain;

import com.house.maintain.housemaintain.dto.UserDto;
import com.house.maintain.housemaintain.util.DaoServiceUtil;
import com.house.maintain.housemaintain.vo.AddressVO;
import com.house.maintain.housemaintain.vo.UserVO;
import com.house.maintain.housemaintain.vo.enums.RoleEnum;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class HouseMaintainApplication implements CommandLineRunner {

	@Autowired
	private DaoServiceUtil daoServiceUtil;
	@Autowired
	private Mapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(HouseMaintainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		daoServiceUtil.rolesService.addNewRoles(RoleEnum.USER);

		UserDto dto = new UserDto();
		dto.setEmail("sarathe@mail.usf.edu");
		dto.setDateOfBirth("02-30-2020");
		dto.setState("IA");
//
		UserVO map = mapper.map(dto, UserVO.class);
		AddressVO map1 = mapper.map(dto, AddressVO.class);
		map.setAddressVO(map1);
		System.out.print("");


	}
}
