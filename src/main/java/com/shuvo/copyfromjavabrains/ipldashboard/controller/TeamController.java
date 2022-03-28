package com.shuvo.copyfromjavabrains.ipldashboard.controller;

import com.shuvo.copyfromjavabrains.ipldashboard.model.Team;
import com.shuvo.copyfromjavabrains.ipldashboard.repository.MatchRepository;
import com.shuvo.copyfromjavabrains.ipldashboard.repository.TeamRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {
 
    private TeamRepository teamRepo;
    private MatchRepository matchRepo;

    public TeamController(TeamRepository teamRepo, MatchRepository matchRepo) {
        this.teamRepo = teamRepo;
        this.matchRepo = matchRepo;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team = this.teamRepo.findByTeamName(teamName);
        team.setMatches(this.matchRepo.findLatestMatchesByTeam(teamName,4));

        return team;
    }
}
