package org.example.exam.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.service.BaseService;
import org.example.exam.entity.Exam;
import org.example.exam.repository.ExamRepository;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamService implements BaseService<Exam, UUID> {

    private static final ExamService examService = new ExamService();
    private final ExamRepository examRepository = ExamRepository.getInstance();


    @Override
    public Exam findById(UUID uuid) {
        return examRepository.findById(uuid);
    }

    @Override
    public List<Exam> getAll() {
        return examRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {
            examRepository.delete(uuid);
    }

    @Override
    public Exam add(Exam exam) {
        return examRepository.add(exam);
    }

    public static ExamService getInstance(){return examService;}
}
