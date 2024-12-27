package com.tka.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.model.Match;
import com.tka.service.MatchServices;
@RestController
@RequestMapping("/api")

public class MatchController {
	@Autowired
	private MatchServices matchService;
	
	
	
	@PostMapping("/matchs")
	public String addMatch(@RequestBody Match match) {
		
		String msg = matchService.addMatch(match);
		
		return msg;
		
	}
	
	@GetMapping("/matchs/all")
	public List<Match>getallMatch(){
		List<Match>Allmatch=matchService.getAllmatch();
		
		return Allmatch;
		
	}
	@GetMapping("/matchs")
	public Object getElementById(@RequestParam int id) {
		Match match=matchService.getMatchById(id);
		if(match!=null) {
			return match;

		}else {
			return "Match not found";

		}
		
		
	}
	@DeleteMapping("/matchs/{id}")
	public void deleteMatch(@PathVariable("id") int id ) {
		matchService.deleteMatch(id);
		
	}
	
	
	@PutMapping("/matchs/{id}")
	public String updateMatch(@RequestBody Match match,@PathVariable int id) {
		return matchService.updateMatch(id,match);
		
	}





}
