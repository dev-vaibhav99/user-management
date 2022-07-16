package com.ci.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ci.dto.CcapDto;
import com.ci.dto.RiwDto;
import com.ci.dto.SnapDto;
import com.ci.service.DataCollectionService;

@RestController
@RequestMapping("/dataCollection")
@CrossOrigin(origins = "*")
public class DataCollectionResource {

	@Autowired
	DataCollectionService dataCollectionService;
	
	@PostMapping("/snap")
	public SnapDto addIncomeDetails(@RequestBody SnapDto snapDto) {
		return dataCollectionService.addIncomeDetails(snapDto);
	}
	
	@PostMapping("/ccap")
	public CcapDto addChildDetails(@RequestBody CcapDto ccapDto){
		return dataCollectionService.addChildDetails(ccapDto);
	}
	
	@PostMapping("/riw")
	public RiwDto addEducationDetails(@RequestBody RiwDto riwDto) {
		return dataCollectionService.addEducationDetails(riwDto);
	}
	
	
}
