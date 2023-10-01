package org.example.question.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.repository.BaseRepository;
import org.example.question.entity.Question;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionRepository extends BaseRepository<UUID,Question> {
    private static final QuestionRepository questionRepository = new QuestionRepository();




    public static QuestionRepository getInstance(){return questionRepository;}

}
