package com.app.teammate_radar_app.Database.Repos;

import com.app.teammate_radar_app.Database.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
