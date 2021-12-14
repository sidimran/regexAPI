package com.springboot.regex.sample.regexonapi.service;

import com.springboot.regex.sample.regexonapi.dto.ResultDto;
import com.springboot.regex.sample.regexonapi.dto.TushionDto;
import com.springboot.regex.sample.regexonapi.entity.Tushion;

public interface TushionService {

	public ResultDto saveTushionData(TushionDto dto);

	public ResultDto getTushionDataById(String id);

	public ResultDto deleteTushionDataById(String id);

	public ResultDto updateTushionDataById(String id,  TushionDto dto);

}
