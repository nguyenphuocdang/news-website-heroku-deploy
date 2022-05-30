package com.example.newswebsite.entities.embedded;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountEmbedded {
    @Indexed(unique = true)
    private String username;

    @JsonIgnore
    private String password;
}
