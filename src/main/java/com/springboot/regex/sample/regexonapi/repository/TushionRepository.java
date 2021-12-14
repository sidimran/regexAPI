package com.springboot.regex.sample.regexonapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.regex.sample.regexonapi.dto.ResultDto;
import com.springboot.regex.sample.regexonapi.entity.Tushion;
import com.springboot.regex.sample.regexonapi.service.TushionService;

@Repository
public interface TushionRepository extends JpaRepository<Tushion, String> {

	@Modifying
	@Transactional
	@Query(value = "delete from tushion t where t.id = :id", nativeQuery = true)
	public void deleteTushionDataById(@Param("id") String id);
	

	

}
