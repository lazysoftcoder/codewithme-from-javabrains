import {React, useEffect, useState} from 'react';
import { MatchdetailCrad } from '../components/MatchDetailCard';
import { MatchLastMatchesCard } from '../components/MatchLastMatchesCard';

export const TeamPage =() => {

    const [team, setTeam] = useState({matches :[]});   // [pass this empty object to initialize the team object]
    
    useEffect(
        () =>{
            const fetchMatches = async () =>{
                const response = await fetch('http://localhost:8080/team/Delhi Capitals');
                const data = await response.json();
                setTeam(data);
            };
            fetchMatches();
        },[]    //[adding this emplty array tells useEffect to call fetch only when the team aobject array is empty]
    );


  return (
    <div className="TeamPage">
      <h1>{team.teamName}</h1>
      <MatchdetailCrad match={team.matches[0]}/>
      { team.matches.slice(1).map(match => <MatchLastMatchesCard match={match}/>)}
    </div>
  );
}
