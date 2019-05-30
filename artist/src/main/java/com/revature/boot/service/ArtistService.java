package com.revature.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.boot.domain.Artist;
import com.revature.boot.repository.ArtistRepository;

@Service
public class ArtistService {
	@Autowired
	ArtistRepository artistRepository;

	public void setArtistRepository(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}
	
	@Transactional
	public List<Artist> getAllArtists() {
		return this.artistRepository.findAll();
	}
	
	@Transactional
	public Artist saveNewArtist(Artist a) {
		return artistRepository.save(a);
	}
	
	@Transactional
	public void deleteById(Long id) {
		artistRepository.deleteById(id);
	}

}
