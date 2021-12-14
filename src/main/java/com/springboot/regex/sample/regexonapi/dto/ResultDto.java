package com.springboot.regex.sample.regexonapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ResultDto {

	private String message;
	private Object data;

}
