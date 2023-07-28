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
@Table(name = "Teams")
public class Team {

    @Id
    private Integer id;

    private Integer teamId;

    private String acceptedRolesArray;

    private Integer game;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    // getters and setters ...
}
