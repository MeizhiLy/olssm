package com.neuedu.olssm.service;

import com.neuedu.olssm.po.Course;

public interface CourseService {
	/**
	 * ��ӿγ�
	 * @param course
	 */
	public void addCourse(Course course);

	/**
	 * ��ҳ��ʾ�γ���Ϣ
	 * @param keyword
	 * @param pageSize
	 * @param curPage
	 */
	public void pageData(String keyword,int pageSize,int curPage);
}
