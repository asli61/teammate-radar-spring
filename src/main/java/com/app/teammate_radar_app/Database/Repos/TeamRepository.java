package com.app.teammate_radar_app.Database.Repos;

import com.app.teammate_radar_app.Database.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
