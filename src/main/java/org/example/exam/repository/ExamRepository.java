package org.example.exam.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.repository.BaseRepository;
import org.example.exam.entity.Exam;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamRepository extends BaseRepository<UUID, Exam> {
    private static final ExamRepository examRepository = new ExamRepository();



    public static ExamRepository getInstance(){return examRepository;}

}
