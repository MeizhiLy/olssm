package com.neuedu.olssm.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.olssm.ex.InvalidParamException;
import com.neuedu.olssm.mapper.TeacherMapper;
import com.neuedu.olssm.mapper.TokenMapper;
import com.neuedu.olssm.po.Teacher;
import com.neuedu.olssm.po.Token;
import com.neuedu.olssm.web.ExInfo;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private TokenMapper tokenMapper;
	
	
	public void addTeacher(Teacher teacher) {
		teacherMapper.add(teacher);
	}

	/**
	 * 判断电话号码是否已经使用
	 */
	public boolean hasTelExists(String tel) {
		Teacher teacher = teacherMapper.getTeacherByTel(tel);
		if(teacher == null) {
			return false;
		}
		
		return true;
	}

	public Teacher login(String tel, String pwd) {
		Teacher teacher = teacherMapper.getTeacherByTel(tel);
		if(teacher == null) {
			throw new InvalidParamException(ExInfo.USER_ACCOUNT_ERROR_CODE,ExInfo.USER_ACCOUNT_ERROR_MSG);
		}
		
		if(!teacher.getPwd().equals(pwd)) {
			throw new InvalidParamException(ExInfo.USER_ACCOUNT_ERROR_CODE,ExInfo.USER_ACCOUNT_ERROR_MSG);
		}
		//存入之前判断之前是否登陆过
		Token existToken = tokenMapper.getTokenByUserId(teacher.getId());
		Token token = new Token();
		token.setUserId(teacher.getId());
		String uuid = UUID.randomUUID().toString();
		token.setToken(uuid);
		
		if(existToken != null) {
			token.setLoginTime(new Date());
			tokenMapper.update(token);
		} else {
			//将用户登录信息存入token表
			tokenMapper.add(token);
		}
		teacher.setToken(token);
		
		return teacher;
	}

}
