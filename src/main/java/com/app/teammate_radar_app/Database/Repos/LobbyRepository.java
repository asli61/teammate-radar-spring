package com.app.teammate_radar_app.Database.Repos;

import com.app.teammate_radar_app.Database.Entities.Lobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LobbyRepository extends JpaRepository<Lobby, Integer> {
}
