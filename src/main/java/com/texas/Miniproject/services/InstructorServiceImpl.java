package com.texas.Miniproject.services;

import com.texas.Miniproject.entity.Instructor;
import com.texas.Miniproject.repository.InstructorRepository;
import com.texas.Miniproject.services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Instructor> getInstructorsByDepartment(Long departmentId) {
        return instructorRepository.findByDepartmentId(departmentId);
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructorDetails) {
        Optional<Instructor> existingInstructor = instructorRepository.findById(id);
        if (existingInstructor.isPresent()) {
            Instructor instructor = existingInstructor.get();
            instructor.setName(instructorDetails.getName());
            instructor.setEmail(instructorDetails.getEmail());
            instructor.setPhone(instructorDetails.getPhone());
            instructor.setDepartment(instructorDetails.getDepartment());
            return instructorRepository.save(instructor);
        }
        return null;
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
}
