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

import com.tka.model.Player;
import com.tka.service.PlayerServices;

@RestController
@RequestMapping("/api")
public class PlayerController {
	@Autowired
	private PlayerServices playerService;
	
	
	
	@PostMapping("/players")
	public String addPlayer(@RequestBody Player player) {
		
		String msg = playerService.addPlayer(player);
		
		return msg;
		
	}
	
	@GetMapping("/players/all")
	public List<Player>getallPlayer(){
		List<Player>Allplayer=playerService.getAllplayer();
		
		return Allplayer;
		
	}
	@GetMapping("/players")
	public Object getElementById(@RequestParam int id) {
		Player player=playerService.getPlayerById(id);
		if(player!=null) {
			return player;

		}else {
			return "Player not found";

		}
		
		
	}
	@DeleteMapping("/players/{id}")
	public void deletePlayer(@PathVariable("id") int id ) {
		playerService.deletePlayer(id);
		
	}
	
	
	@PutMapping("/players/{id}")
	public String updatePlayer(@RequestBody Player player,@PathVariable int id) {
		return playerService.updatePlayer(id,player);
		
	}



}
