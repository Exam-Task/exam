package org.example.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity<ID> {
    private ID id;
    private LocalDateTime modified;
    private LocalDateTime created;
}
