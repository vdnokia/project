package com.springrest.RestfulProject.services;

import java.util.ArrayList;
import java.util.stream.Collectors; 
import java.util.List;
import org.springframework.stereotype.Service;
import com.springrest.RestfulProject.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(1,"Java Course","This Course is for Programmer"));
		list.add(new Course(2,"C++ Course","This Course is for beginner"));
		list.add(new Course(3,"PHP Course","This Course is for Developers"));
		
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c = null;
		for(Course course : list)         //traversing the list to find the course id.
		{
			if(course.getId()==courseId)
			{
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) {
		list.forEach(e->{
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}
    
	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}
}
