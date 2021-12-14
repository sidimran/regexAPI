package com.springboot.regex.sample.regexonapi.converter;

import org.springframework.stereotype.Component;

import com.springboot.regex.sample.regexonapi.dto.TushionDto;
import com.springboot.regex.sample.regexonapi.entity.Tushion;

@Component
public class TushionConverter {

	public TushionDto entityToDto(Tushion tushion) {

		TushionDto dto = new TushionDto();
		dto.setId(tushion.getId());
		dto.setName(tushion.getName());
		dto.setAddress(tushion.getAddress());
		dto.setDoj(tushion.getDoj());
		return dto;
	}

	public Tushion dtoToEntity(TushionDto dto) {
		Tushion tushion = new Tushion();
		tushion.setId(dto.getId());
		tushion.setName(dto.getName());
		tushion.setAddress(dto.getAddress());
		tushion.setDoj(dto.getDoj());
		return tushion;
	}

}
