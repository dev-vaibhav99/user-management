package com.vaibhav.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.dto.CcapDto;
import com.vaibhav.dto.RiwDto;
import com.vaibhav.dto.SnapDto;
import com.vaibhav.entity.DataCollection;
import com.vaibhav.repo.DataCollectionRepo;
import com.vaibhav.service.DataCollectionService;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

	@Autowired
	private DataCollectionRepo dataCollectionRepo;

	private ModelMapper mapper;

	@Override
	public SnapDto addIncomeDetails(SnapDto snapDto) {
		DataCollection snapEntity = mapper.map(snapDto, DataCollection.class);
		DataCollection savedIncomeDetails = dataCollectionRepo.save(snapEntity);
		return mapper.map(savedIncomeDetails, SnapDto.class);

	}

	@Override
	public CcapDto addChildDetails(CcapDto ccapDto) {
		DataCollection ccapEntity = mapper.map(ccapDto, DataCollection.class);
		DataCollection savedChildDetails = dataCollectionRepo.save(ccapEntity);
		return mapper.map(savedChildDetails, CcapDto.class);
	}

	@Override
	public RiwDto addEducationDetails(RiwDto riwDto) {
		DataCollection riwEntity = mapper.map(riwDto, DataCollection.class);
		DataCollection savedEduDetails = dataCollectionRepo.save(riwEntity);
		return mapper.map(savedEduDetails, RiwDto.class);
	}

}
