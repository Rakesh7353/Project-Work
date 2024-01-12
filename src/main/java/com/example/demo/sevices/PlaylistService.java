package com.example.demo.sevices;

import java.util.List;

import com.example.demo.entity.Playlist;

public interface PlaylistService {
	
	

	public List<Playlist> fetchAllPlaylists();

	public void addplaylist(Playlist playlist);

	
}
