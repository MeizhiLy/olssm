package com.neuedu.olssm.mapper;

import com.neuedu.olssm.po.Teacher;

public interface TeacherMapper {
	/**
	 * 添加
	 * @param teacher
	 */
	public void add(Teacher teacher);
	
	/**
	 * 根据电话号码查询教师
	 * @param Tel
	 * @return
	 */
	public Teacher getTeacherByTel(String Tel);
	
	/**
	 * 根据Token查询教师信息
	 * @param Token
	 * @return
	 */
	public Teacher getTeacherByToken(String Token);


}
