package com.example.springbootdemo.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TaskDTO implements Identifiable<UUID> {
    @EqualsAndHashCode.Include
    private UUID id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private User createdBy;
}
