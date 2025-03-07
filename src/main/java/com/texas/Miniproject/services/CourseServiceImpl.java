package com.texas.Miniproject.services;

import com.texas.Miniproject.entity.Course;
import com.texas.Miniproject.repository.CourseRepository;
import com.texas.Miniproject.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    @Override
    public List<Course> getCoursesByDepartment(Long departmentId) {
        return courseRepository.findByDepartmentId(departmentId);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course courseDetails) {
        Optional<Course> existingCourse = courseRepository.findById(id);
        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();
            course.setCourseName(courseDetails.getCourseName());
            course.setCourseDescription(courseDetails.getCourseDescription());
            course.setCredits(courseDetails.getCredits());
            course.setDepartment(courseDetails.getDepartment());
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
