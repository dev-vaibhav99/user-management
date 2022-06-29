package com.vaibhav.service;

import org.springframework.stereotype.Service;

import com.vaibhav.dto.CcapDto;
import com.vaibhav.dto.RiwDto;
import com.vaibhav.dto.SnapDto;
@Service
public interface DataCollectionService {

	public SnapDto addIncomeDetails(SnapDto snapDto);

	public CcapDto addChildDetails(CcapDto ccapDto);

	public RiwDto addEducationDetails(RiwDto riwDto);	
}
