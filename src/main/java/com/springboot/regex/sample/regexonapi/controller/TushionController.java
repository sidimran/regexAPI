package com.springboot.regex.sample.regexonapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.regex.sample.regexonapi.dto.ResultDto;
import com.springboot.regex.sample.regexonapi.dto.TushionDto;
import com.springboot.regex.sample.regexonapi.service.TushionService;

@RestController
@RequestMapping("/api/v1/tushion")
public class TushionController {

	@Autowired
	private TushionService tushionService;

	//Sample 1
	@PostMapping("*")
	public ResultDto saveData(@Valid @RequestBody TushionDto dto) {
		return tushionService.saveTushionData(dto);
	}
	
	//Sample2
//	@GetMapping("/test/g?een/{id}")
//	public ResultDto getDataByIdRegex1(@PathVariable(value = "id") String id) {
//		return tushionService.getTushionDataById(id);
//	}
	
	//Sample3
//	@GetMapping("/test/{name}/{id}")
//	public ResultDto getDataByIdRegex2(@PathVariable("name") String name,@PathVariable(value = "id") String id) {
//		return tushionService.getTushionDataById(id);
//	}

	//Sample4
//	@GetMapping("/test/{name:[A-Z]}/{id}")
//	public ResultDto getDataByIdRegex3(@PathVariable("name") String name ,@PathVariable(value = "id") String id) {
//		return tushionService.getTushionDataById(id);
//	}
	
	
	//Sample5
//	@GetMapping("/test/{name:[a-z]+}/{id}")
//	public ResultDto getDataByIdRegex4(@PathVariable("name") String name ,@PathVariable(value = "id") String id) {
//		return tushionService.getTushionDataById(id);
//	}
//	
	
	//Sample 6
//	@GetMapping("/test/{name:\\d+}/{id}")
//	public ResultDto getDataByIdRegex5(@PathVariable("name") String name ,@PathVariable(value = "id") String id) {
//		return tushionService.getTushionDataById(id);
//	}
	
	
	//Sample 7
//	@GetMapping("/test/number_{name:\\d+}/{id}")
//	public ResultDto getDataByIdRegex7(@PathVariable("name") String name ,@PathVariable(value = "id") String id) {
//		return tushionService.getTushionDataById(id);
//	}
	
	//Sample 8 -- need to check
	@GetMapping("/test/{name1}_{name:\\d+}/{id}")
	public ResultDto getDataByIdRegex8(@PathVariable("name1") String name1, @PathVariable("name")String name  ,@PathVariable(value = "id") String id) {
		return tushionService.getTushionDataById(id);
	}
	


    
	@PutMapping()
	public ResultDto updateDataById(@RequestParam(defaultValue = "0") String id, @Valid @RequestBody TushionDto dto) {
		return tushionService.updateTushionDataById(id, dto);

	}

	@DeleteMapping("{id}")
	public ResultDto deleteDataById(@PathVariable(value = "name") String id) {
		return tushionService.deleteTushionDataById(id);
	}

}
