package com.example.task_manager.entities;

//import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name="users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Integer userId;

    private String username;

    private String password;

//    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<TaskList> taskLists;
}
