package com.ci.service;

import org.springframework.stereotype.Service;

import com.ci.dto.CcapDto;
import com.ci.dto.RiwDto;
import com.ci.dto.SnapDto;
@Service
public interface DataCollectionService {

	public SnapDto addIncomeDetails(SnapDto snapDto);

	public CcapDto addChildDetails(CcapDto ccapDto);

	public RiwDto addEducationDetails(RiwDto riwDto);	
}
