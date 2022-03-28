import {React} from 'react';

export const MatchLastMatchesCard =({match}) => {
  return (
    <div className="MatchLastMatchesCard">
        <p>{match.team1} vs {match.team2}</p>
    </div>
  );
}