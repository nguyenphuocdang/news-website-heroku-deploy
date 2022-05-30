package com.example.newswebsite.entities;
import com.example.newswebsite.entities.embedded.AccountEmbedded;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private AccountEmbedded account;

    @Indexed(unique = true)
    private String email;

    private String phone;

    private String fullname;

    private String image;

    private String description;

    private String role;
}

