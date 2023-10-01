package org.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private UUID userId;
    private String name;
    private String surname;
    private String password;
    private String username;
    private List<UUID> examResults;
}
