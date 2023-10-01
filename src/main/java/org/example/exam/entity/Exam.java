package org.example.exam.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.common.entity.BaseEntity;
import org.example.question.entity.Question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Exam extends BaseEntity<UUID> {
    private String name;
    private List<Question> questions;

    public Exam(UUID uuid, LocalDateTime modified, LocalDateTime created, String name, List<Question> questions) {
        super(uuid, modified, created);
        this.name = name;
        this.questions = questions;
    }
}
