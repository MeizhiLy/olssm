package com.neuedu.olssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.olssm.po.Course;

public interface CourseMapper {
	/**
	 * 添加课程
	 * @param course
	 */
	public void add(Course course);
	/**
	 * 
	 * @param keyword
	 * @return
	 */
	public int getCourseByKeywordCount(@Param("keyword") String keyword);
	/**
	 * 分页查询
	 * @param keyword
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	public List<Course> getCourseByKeyword(@Param("keyword") String keyword,@Param("begin")int begin,@Param("pageSize")int pageSize);
 
}