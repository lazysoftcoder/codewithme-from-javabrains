package com.shuvo.copyfromjavabrains.ipldashboard.data;

import java.time.LocalDate;

import com.shuvo.copyfromjavabrains.ipldashboard.model.Match;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    
    Match match = new Match();

    match.setId(Long.parseLong(matchInput.getId()));
    match.setCity(matchInput.getCity());
    
    match.setDate(LocalDate.parse(matchInput.getDate()));
    match.setPlayerOfMatch(matchInput.getPlayer_of_match());
    match.setVenue(matchInput.getVenue());

    //set team1 as the team who bats first
    String firstInningsTeam,secondInningsTeam;

    if("bat".equals(matchInput.getToss_decision()) && matchInput.getToss_winner().equals(matchInput.getTeam1())){
        firstInningsTeam = matchInput.getTeam1();
        secondInningsTeam = matchInput.getTeam2();
    }else{
        firstInningsTeam = matchInput.getTeam2();
        secondInningsTeam = matchInput.getTeam1();
    }

    match.setTeam1(firstInningsTeam);
    match.setTeam2(secondInningsTeam);
    match.setTossDecision(matchInput.getToss_decision());
    match.setTossWinner(matchInput.getToss_winner());
    match.setMatchWinner(matchInput.getWinner());
    match.setResult(matchInput.getResult());
    match.setResultMargin(matchInput.getResult_margin());
    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());

    return match;
  }

}