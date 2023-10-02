package org.example.user.entity;

import lombok.*;
import org.example.common.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends BaseEntity<UUID> {
    private UUID userId;
    private String name;
    private String surname;
    private String password;
    private String username;
    private UserType userType;
    private List<UUID> examResults;

    @Builder
    public User(UUID uuid, LocalDateTime modified, LocalDateTime created, UUID userId, String name, String surname, String password, String username, List<UUID> examResults) {
        super(uuid, modified, created);
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
        this.examResults = examResults;
    }
}
