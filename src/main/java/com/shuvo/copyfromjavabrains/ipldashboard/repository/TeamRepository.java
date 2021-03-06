package com.shuvo.copyfromjavabrains.ipldashboard.repository;

import com.shuvo.copyfromjavabrains.ipldashboard.model.Team;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>{
    
    
    Team findByTeamName(String teamName);
}
