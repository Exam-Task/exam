package org.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.entity.BaseEntity;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity<UUID> {
    private UUID userId;
    private String name;
    private String surname;
    private String password;
    private String username;
    private UserType userType;
    private List<UUID> examResults;
}
