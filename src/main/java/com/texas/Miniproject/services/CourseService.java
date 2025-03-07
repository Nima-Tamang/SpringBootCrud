package com.texas.Miniproject.services;

import com.texas.Miniproject.entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    List<Course> getCoursesByDepartment(Long departmentId);
    Course addCourse(Course course);
    Course updateCourse(Long id, Course courseDetails);
    void deleteCourse(Long id);
}
