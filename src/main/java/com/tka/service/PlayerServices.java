package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.PlayerDao;
import com.tka.model.Player;
@Service
public class PlayerServices {
	@Autowired
	private PlayerDao playerDao;
	
	public String addPlayer(Player player) {
		String msg = playerDao.addPlayer(player);
		
		return msg;
		
	}

	public List<Player> getAllplayer() {
		List<Player>allPlayers=playerDao.getAllPlayer();
		return allPlayers;
	}
	
	public Player getPlayerById(int id) {
		Player player=playerDao.getPlayerById(id);
		return player;
		
	}
		public String deletePlayer(int id) {
			 int status=playerDao.deletePlayer(id);
			 if (status==0) {
				return "Player not found";
			}else {
				return "Player deleted";

			}
		
			
		}
		public String updatePlayer(int id,Player player) {
			int status = playerDao.updatePlayer(id, player);
			if(status==0) {
				return "Player not found";
			}else {
				return "Player Update";
			}
			
		}


}
