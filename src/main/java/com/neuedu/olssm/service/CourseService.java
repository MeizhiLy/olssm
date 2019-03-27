package com.neuedu.olssm.service;

import com.neuedu.olssm.po.Course;

public interface CourseService {
	/**
	 * 添加课程
	 * @param course
	 */
	public void addCourse(Course course);

	/**
	 * 分页显示课程信息
	 * @param keyword
	 * @param pageSize
	 * @param curPage
	 */
	public void pageData(String keyword,int pageSize,int curPage);
}
