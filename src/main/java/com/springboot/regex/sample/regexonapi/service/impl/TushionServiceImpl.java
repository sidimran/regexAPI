package com.springboot.regex.sample.regexonapi.service.impl;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.regex.sample.regexonapi.converter.TushionConverter;
import com.springboot.regex.sample.regexonapi.dto.ResultDto;
import com.springboot.regex.sample.regexonapi.dto.TushionDto;
import com.springboot.regex.sample.regexonapi.entity.Tushion;
import com.springboot.regex.sample.regexonapi.repository.TushionRepository;
import com.springboot.regex.sample.regexonapi.service.TushionService;

@Service
public class TushionServiceImpl implements TushionService {

	@Autowired
	private TushionRepository tushionRepository;

	@Autowired
	private TushionConverter tushionConverter;

	Logger logger = Logger.getLogger(TushionServiceImpl.class.getName());
	ResultDto dto = new ResultDto();

	@Override
	public ResultDto saveTushionData(TushionDto tushionDto) {

		try {

			Tushion tushion= tushionConverter.dtoToEntity(tushionDto);
			tushionRepository.save(tushion);
			dto.setMessage("Stored Scuuessfully");
			dto.setData(tushion);

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return dto;
	}

	@Override
	public ResultDto getTushionDataById(String id) {

		Optional<Tushion> tushion = tushionRepository.findById(id);
		try {

			if (tushion.isEmpty()) {
				dto.setMessage("Invalid Id");

			} else {
				dto.setMessage("Fetched Successfully");
				dto.setData(tushion);

			}
		} catch (InvalidParameterException ex) {
			logger.info(ex.getMessage());
		}
		return dto;

	}

	@Override
	public ResultDto deleteTushionDataById(String id) {
		Optional<Tushion> tushion = tushionRepository.findById(id);

		try {

			if (tushion.isEmpty()) {
				dto.setMessage("Invalid Id");
			} else {
				
				tushionRepository.deleteTushionDataById(id);	
				dto.setMessage("Valid Id");
				dto.setData(tushion);
			}

		} catch (InvalidParameterException ex) {
			logger.info(ex.getMessage());
		}
		return dto;
	}

	@Override
	public ResultDto updateTushionDataById(String id, TushionDto tushionDto) {
		Optional<Tushion> tushion = tushionRepository.findById(id);
		try {

			if (tushion.isEmpty()) {
				dto.setMessage("Invalid Id");
				return dto;
			} else {

				Tushion tushion2 = tushion.get();
				if (Objects.nonNull(tushion2.getName()) && !"".equalsIgnoreCase(tushion2.getName())) {
					tushion2.setName(tushionDto.getName());
				}

				if (Objects.nonNull(tushion2.getAddress()) && !"".equalsIgnoreCase(tushion2.getAddress())) {
					tushion2.setAddress(tushionDto.getAddress());
				}

				if (Objects.nonNull(tushion2.getDoj())) {
					tushion2.setDoj(tushionDto.getDoj());
				}

				tushionRepository.save(tushion2);
				TushionDto tushionDTO = tushionConverter.entityToDto(tushion2);
				dto.setMessage("Updated Successfully");
				dto.setData(tushionDTO);

			}

		} catch (InvalidParameterException ex) {
			logger.info(ex.getMessage());
		}
		return dto;
	}

}
