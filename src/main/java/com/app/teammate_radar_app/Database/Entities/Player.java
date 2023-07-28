package com.app.teammate_radar_app.Database.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Player")
public class Player {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer game;

    private Integer server;

    private Integer honorRating;

    private Boolean searching;

    private Boolean accepted;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private Integer primaryRole;

    private Integer secondaryRole;

    // getters and setters ...
}