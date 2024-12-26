package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.TeamDao;
import com.tka.model.Team;

@Service
public class TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	public String addTeam(Team team) {
		String msg = teamDao.addTeam(team);
		
		return msg;
		
	}

	public List<Team> getAllteam() {
		List<Team>allTeams=teamDao.getAllTeam();
		return allTeams;
	}
	
	public Team getTeamById(int id) {
		Team team=teamDao.getTeamById(id);
		return team;
		
	}
		public String deleteTeam(int id) {
			int status=teamDao.deleteTeam(id);
			if(status==0) {
				return "Team not found to delete";
			}else {
				return "Team Deleted";

			}
			
			
		}
		public int updateTeam(int id,Team team) {
			return teamDao.updateTeam(id, team);
			
		}
}
