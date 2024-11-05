package com.schoolMicro.school_micro.service;

import com.schoolMicro.school_micro.entity.School;
import com.schoolMicro.school_micro.kafkaSender.KafkaSender;
import com.schoolMicro.school_micro.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final KafkaSender kafkaSender;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository, KafkaSender kafkaSender) {
        this.schoolRepository = schoolRepository;
        this.kafkaSender = kafkaSender;
    }

    @Transactional()
    public boolean addSchool(School school) {
        boolean result = false;
        try {
            schoolRepository.save(school);
            kafkaSender.sendMessage(school);
            result = true;
        }catch (Exception _) {

        }
        return result;
    }
    @Transactional()
    public List<School> fetchSchools() {
        return schoolRepository.findAll();
    }
    @Transactional()
    public School getSchoolById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }
}
