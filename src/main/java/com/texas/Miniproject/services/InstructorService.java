package com.texas.Miniproject.services;

import com.texas.Miniproject.entity.Instructor;
import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
    List<Instructor> getInstructorsByDepartment(Long departmentId);
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Long id, Instructor instructorDetails);
    void deleteInstructor(Long id);
}
