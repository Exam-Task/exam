package org.example.question.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.service.BaseService;
import org.example.question.entity.Question;
import org.example.question.repository.QuestionRepository;

import java.util.List;
import java.util.UUID;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionService implements BaseService<Question, UUID> {


    private static final QuestionService questionService = new QuestionService();
    private final QuestionRepository questionRepository = QuestionRepository.getInstance();

    @Override
    public Question findById(UUID uuid) {
        return questionRepository.findById(uuid);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public void delete(UUID uuid) {
        questionRepository.delete(uuid);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }


    public static QuestionService getInstance(){return questionService;}
}
