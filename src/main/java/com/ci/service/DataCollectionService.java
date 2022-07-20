package com.ci.service;

import org.springframework.stereotype.Service;

import com.ci.dto.CcapDto;
import com.ci.dto.QhpDto;
import com.ci.dto.RiwDto;
import com.ci.dto.SnapDto;
@Service
public interface DataCollectionService {

	SnapDto addIncomeDetails(SnapDto snapDto);

	CcapDto addChildDetails(CcapDto ccapDto);

	RiwDto addEducationDetails(RiwDto riwDto);
	
	QhpDto addDetailsForQhp(QhpDto qhpDto);
	
//	List<DataCollection> getAll();
}
