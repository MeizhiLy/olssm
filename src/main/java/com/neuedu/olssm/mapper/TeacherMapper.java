package com.neuedu.olssm.mapper;

import com.neuedu.olssm.po.Teacher;

public interface TeacherMapper {
	/**
	 * ���
	 * @param teacher
	 */
	public void add(Teacher teacher);
	
	/**
	 * ���ݵ绰�����ѯ��ʦ
	 * @param Tel
	 * @return
	 */
	public Teacher getTeacherByTel(String Tel);
	
	/**
	 * ����Token��ѯ��ʦ��Ϣ
	 * @param Token
	 * @return
	 */
	public Teacher getTeacherByToken(String Token);


}
