package com.neuedu.olssm.service;

import com.neuedu.olssm.po.Teacher;

public interface TeacherService {
	/**
	 * ��ӽ�ʦ
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	
	/**
	 * �ж��ֻ����Ƿ��Ѿ�ע��
	 * @param tel
	 * @return
	 */
	public boolean hasTelExists(String tel);
	
	/**
	 * �û���¼
	 * @param tel
	 * @param pwd
	 * @return
	 */
	public Teacher login(String tel,String pwd);
}
