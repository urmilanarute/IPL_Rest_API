package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.model.Team;
import com.tka.service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/api/teams")
	public String addTeam(@RequestBody Team team) {
		
		String msg = teamService.addTeam(team);
		
		return msg;
		
	}
	
	@GetMapping("/api/teams/all")
	public List<Team>getallTeam(){
		List<Team>Allteam=teamService.getAllteam();
		
		return Allteam;
		
	}
	@GetMapping("/api/teams")
	public Object getElementById(@RequestParam int id) {
		Team team=teamService.getTeamById(id);
		if(team!=null) {
			return team;

		}else {
			return "Team not found";

		}
		
		
	}
	@DeleteMapping("/api/teams/{id}")
	public void deleteTeam(@PathVariable("id") int id ) {
		teamService.deleteTeam(id);
		
	}
	
	
	@PutMapping("/api/teams/{id}")
	public String updateTeam(@RequestBody Team team,@PathVariable int id) {
		return teamService.updateTeam(id,team);
		
	}

}
