package com.springboot.regex.sample.regexonapi.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TushionDto {

	private String id;

	@NotNull(message = "Enter the Name")
	private String name;

	@NotNull(message = "Enter the Address")
	private String Address;

	@NotNull(message = "Enter the DOJ")
	private Date doj;

}
