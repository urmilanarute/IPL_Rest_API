package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tka.model.Match;
@Repository
public class Matchdao {
	List<Match>matchs=new ArrayList<Match>();
	
	

	public Matchdao() {
		matchs.add(new Match(1, "MI", "RCB", "20-10-24", "Wankhede", "Mumbai indians won"));
		matchs.add(new Match(2, "RCB", "MI","20-4-2024","Pune", "Mumbai indians won"));
		
	}

	public String addMatch(Match match) {
		matchs.add(match);
		
		return "Added Successfully";
		
	}

	public List<Match>getAllMatch(){
		
		
		return matchs;
		
	}
	
	public Match getMatchById(int id) {
		
		for (Match match : matchs) {
			if (match.getMatchId()==id) {
				return match;
			}
		}
		return null;
		
	}
	
	public int deleteMatch(int id) {
		for (Match match : matchs) {
			if (match.getMatchId()==id) {
				matchs.remove(match);
				return 1;
			}
		}
		return 0;
	}
	
	public int updateMatch(int id,Match match) {
		int status=deleteMatch(id);
		if (status==1) {
			matchs.add(match);
			return 1;
		}else {
			return 0;
		}
		
	}


}
