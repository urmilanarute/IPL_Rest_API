package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tka.dao.Matchdao;
import com.tka.model.Match;
@Service
public class MatchServices {
	@Autowired
	private Matchdao matchDao;
	
	public String addMatch(Match match) {

		String msg = matchDao.addMatch(match);
		
		return msg;
		
	}

	public List<Match> getAllmatch() {
		List<Match>allMatchs=matchDao.getAllMatch();
		return allMatchs;
	}
	
	public Match getMatchById(int id) {
		Match match=matchDao.getMatchById(id);
		return match;
		
	}
		public String deleteMatch(int id) {
			 int status=matchDao.deleteMatch(id);
			 if (status==0) {
				return "Match not found";
			}else {
				return "Match deleted";

			}
		
			
		}
		public String updateMatch(int id,Match match) {
			int status = matchDao.updateMatch(id, match);
			if(status==0) {
				return "Match not found";
			}else {
				return "Match Update";
			}
			
		}


}
