package com.ci.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ci.bindings.UserInfo;
import com.ci.dto.UserResponseDto;
import com.ci.service.PlanService;
import com.ci.service.UserService;

@Component
public class UserUtils {
	
	@Autowired
	UserInfo userInfo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PlanService planService;
	
//	private ModelMapper mapper;
	
	public void setData(UserResponseDto dto) {
//		mapper = new ModelMapper();
		userInfo.setIndvFirstName(dto.getFirstName());
		userInfo.setIndvLastName(dto.getLastName());
		userInfo.setIndvDob(dto.getDob());
		
//		UserInfo planDetails = mapper.map(planService.getPlanById(dto.getId()), UserInfo.class);
		System.out.println(userInfo);
		
//		System.out.println(planDetails);
	}
}
