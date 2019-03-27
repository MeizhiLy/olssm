package com.neuedu.olssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.olssm.mapper.CourseMapper;
import com.neuedu.olssm.po.Course;
import com.neuedu.olssm.web.PageData;

//加上Service后就会被容器自动扫描
@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;

	public void addCourse(Course course) {
		courseMapper.add(course);
	}

	public void pageData(String keyword, int pageSize, int curPage) {
		int begin =(curPage-1)*pageSize;
		int total = courseMapper.getCourseByKeywordCount(keyword);
		List<Course> data = courseMapper.getCourseByKeyword(keyword,begin,pageSize);
		PageData<Course> pages = new PageData<Course>(pageSize,curPage);
		pages.setTotalPage(total);
		pages.setData(data);
		return ;
		
	}

}
