import {React} from 'react';

export const MatchdetailCrad =({match}) => {

    if(!match) return null;
    return (
        <div className="MatchdetailCrad">
        <h3>Latest Matches</h3>
        <h4>Match Detail</h4>
        <h4>{match.team1} vs {match.team2}</h4>
        </div>
    );
}