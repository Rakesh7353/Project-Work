package com.example.demo.sevices;

import java.util.List;

import com.example.demo.entity.Song;

public interface SongService {
	public void addSong(Song song);
	public List<Song> fetchAllSongs();
	
	public boolean songExitst(String name);
	public void updateSong(Song s);
}
