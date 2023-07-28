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
@Table(name = "Lobbies")
public class Lobby {

    @Id
    private Integer id;

    private String lobbyPlayersArray;

    @OneToMany(mappedBy = "lobby")
    private List<User> users;

    // getters and setters ...
}
