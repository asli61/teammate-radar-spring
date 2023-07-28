package com.app.teammate_radar_app.Database.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Users")
public class User {

    @Id
    private Integer id;

    @Column(unique = true)
    private String email;

    private String password;

    private Integer role;

    @ManyToOne
    @JoinColumn(name = "lobby_id")
    private Lobby lobby;

    private String friendsArray;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Player> players;

    // getters and setters ...
}
