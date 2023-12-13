package com.example.springbootdemo.model;

import lombok.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Identifiable<UUID> {
    @EqualsAndHashCode.Include
    private UUID id;
    @NonNull
    private String email;
    @NonNull
    private String username;
    @NonNull
    private String password;
}