package com.example.demo.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repository.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService{
	
	@Autowired
	PlaylistRepository repo;

	
	@Override
	public List<Playlist> fetchAllPlaylists(){
		return repo.findAll();
	}
	@Override
	public void addplaylist(Playlist playlist) {
		repo.save(playlist);		
	}
	
	
}
