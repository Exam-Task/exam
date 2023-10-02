package org.example.question.entity;

import lombok.*;
import org.example.answer.entity.Answer;
import org.example.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;



@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Question extends BaseEntity<UUID> {
    private String question;
    private List<Answer> answers;

    public Question(UUID uuid, LocalDateTime modified, LocalDateTime created, String question, List<Answer> answers) {
        super(uuid, modified, created);
        this.question = question;
        this.answers = answers;
    }
}
