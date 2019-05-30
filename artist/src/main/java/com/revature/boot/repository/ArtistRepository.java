package com.revature.boot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.boot.domain.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{
	Artist findByName(String name);
	
	@Transactional
	List<Artist> findByIdBetween(Integer min, Integer max);
}
