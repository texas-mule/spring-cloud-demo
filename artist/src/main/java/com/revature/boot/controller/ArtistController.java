package com.revature.boot.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.boot.domain.Artist;
import com.revature.boot.service.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {
	@Autowired
	ArtistService artistService;
	
	@GetMapping
	public List<Artist> getAll() {
		return artistService.getAllArtists();
	}
	
	@PostMapping
	public Artist add(@RequestBody @Valid Artist a, Errors errors) {
		if(errors.hasErrors()) return null;
		return artistService.saveNewArtist(a);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		artistService.deleteById(id);
		return "deleted!";
	}
	
	@GetMapping("/oops")
	public void oops() throws IOException {
		throw new IOException();
	}
	
	@ExceptionHandler(IOException.class)
	@ResponseStatus(value=HttpStatus.I_AM_A_TEAPOT)
	public String ioProblem() {
		return "oops!";
	}
}
