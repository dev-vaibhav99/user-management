package com.vaibhav.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.dto.CcapDto;
import com.vaibhav.dto.RiwDto;
import com.vaibhav.dto.SnapDto;
import com.vaibhav.service.DataCollectionService;

@RestController
@RequestMapping("/dataCollection")
@CrossOrigin(origins = "http://localhost:4200")

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
