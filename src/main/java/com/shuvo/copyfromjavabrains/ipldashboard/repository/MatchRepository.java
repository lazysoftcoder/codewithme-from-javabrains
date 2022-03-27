package com.shuvo.copyfromjavabrains.ipldashboard.repository;

import java.util.List;

import com.shuvo.copyfromjavabrains.ipldashboard.model.Match;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long>{
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pagable);

    default List<Match> findLatestMatchesByTeam(String teamName, int matchCount){
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, matchCount));
    }
}
