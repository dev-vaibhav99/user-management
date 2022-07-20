package com.ci.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.dto.CcapDto;
import com.ci.dto.QhpDto;
import com.ci.dto.RiwDto;
import com.ci.dto.SnapDto;
import com.ci.entity.Ccap;
import com.ci.entity.Qhp;
import com.ci.entity.Riw;
import com.ci.entity.Snap;
import com.ci.exceptions.CaseNotFoundException;
import com.ci.repo.CaseRepo;
import com.ci.repo.CcapRepo;
import com.ci.repo.QhpRepo;
import com.ci.repo.RiwRepo;
import com.ci.repo.SnapRepo;
import com.ci.service.DataCollectionService;

@Service
public class DataCollectionServiceImpl implements DataCollectionService {

//	@Autowired
//	private DataCollectionRepo dataCollectionRepo;
	
	@Autowired
	private CaseRepo caseRepo;

	@Autowired
	private SnapRepo snapRepo;

	@Autowired
	private CcapRepo ccapRepo;

	@Autowired
	private RiwRepo riwRepo;
	
	@Autowired
	private QhpRepo qhpRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public SnapDto addIncomeDetails(SnapDto snapDto) {
		if(caseRepo.existsById(snapDto.getCaseId())) {
			Snap snapEntity = mapper.map(snapDto, Snap.class);
			Snap savedIncomeDetails = snapRepo.save(snapEntity);
			return mapper.map(savedIncomeDetails, SnapDto.class);
		} else {
			throw new CaseNotFoundException();
		}
	}

	@Override
	public CcapDto addChildDetails(CcapDto ccapDto) {
		if(caseRepo.existsById(ccapDto.getCaseId())) {
			Ccap ccapEntity = mapper.map(ccapDto, Ccap.class);
			Ccap savedChildDetails = ccapRepo.save(ccapEntity);
			return mapper.map(savedChildDetails, CcapDto.class);
		} else {
			throw new CaseNotFoundException();
		}
	}

	@Override
	public RiwDto addEducationDetails(RiwDto riwDto) {
		if(caseRepo.existsById(riwDto.getCaseId())) {
			Riw riwEntity = mapper.map(riwDto, Riw.class);
			Riw savedEduDetails = riwRepo.save(riwEntity);
			return mapper.map(savedEduDetails, RiwDto.class);
		} else {
			throw new CaseNotFoundException();
		}
	}

	@Override
	public QhpDto addDetailsForQhp(QhpDto qhpDto) {
		if(caseRepo.existsById(qhpDto.getCaseId())) {
			Qhp savedDetails = qhpRepo.save(mapper.map(qhpDto, Qhp.class));
			return mapper.map(savedDetails, QhpDto.class);
		} else {
			throw new CaseNotFoundException();
		}
	}
	
	
}