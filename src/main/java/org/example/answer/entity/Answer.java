package org.example.answer.entity;

import lombok.*;
import org.example.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;



@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Answer extends BaseEntity<UUID> {
    private String name;
    private boolean answerIsTrue;

    public Answer(UUID uuid, LocalDateTime modified, LocalDateTime created, String name, boolean answerIsTrue) {
        super(uuid, modified, created);
        this.name = name;
        this.answerIsTrue = answerIsTrue;
    }
}
