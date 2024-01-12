package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Song;
import com.example.demo.sevices.PlaylistService;
import com.example.demo.sevices.SongService;
@Controller
public class PlayListController {

	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistService playlistservice;
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model model) {
		List<Song>songList = songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		
		return "createPlaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		//updating playlist tabel
		playlistservice.addplaylist(playlist);
		
		List<Song> songList = playlist.getSongs();
			for(Song s : songList) {
				s.getPlayPlaylists().add(playlist);
				songService.updateSong(s);
			}
		return "AdminHome";
	}
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
		List<Playlist>allPlaylists=playlistservice.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayPlaylists";
		
		
	}
}
