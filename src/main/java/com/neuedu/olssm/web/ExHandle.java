package com.neuedu.olssm.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.neuedu.olssm.ex.InvalidParamException;

@RestControllerAdvice
public class ExHandle {
	private static Logger log= Logger.getLogger(ExHandle.class);
	@ExceptionHandler(Exception.class)
	public ApiResult exception(Exception e) {
		e.printStackTrace();
		ApiResult ars = ApiResult.build();
		ars.setCode(ExInfo.SERVER_ERROR_CODE);
		ars.setMsg(ExInfo.SERVER_ERROR_MSG);
		log.info("返回信息"+ars);
		return ars;	
	}
	
	@ExceptionHandler(BindException.class)
	public ApiResult bindExceotion(BindException e) {
		BindingResult bingResult = e.getBindingResult();
		Map<String,String> errMap = new HashMap<String, String>();
		
		if(bingResult.hasErrors()) {
			List<ObjectError> errors = bingResult.getAllErrors();
			for(ObjectError error :errors) {
				FieldError ferror = (FieldError) error;
				errMap.put(ferror.getField(), ferror.getDefaultMessage());
			}
		}
		ApiResult ars = ApiResult.build();
		ars.setCode(ExInfo.PARAM_ERROR_CODE);
		ars.setMsg(ExInfo.PARAM_ERROR_MSG);
		ars.setData(errMap);
		log.info("返回信息"+ars);
		return ars;
	}
	@ExceptionHandler(InvalidParamException.class)
	public ApiResult InvalidParamException(InvalidParamException e) {
		ApiResult ars = ApiResult.build();
		ars.setCode(e.getCode());
		ars.setMsg(e.getMsg());
		log.info("返回信息"+ars);
		return ApiResult.build().setData(rs);
		
	}
	

}
