package com.Velco.REPOSITORY;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Velco.MODEL.References;

@Repository
public interface ReferencesRepository extends JpaRepository<References, Long> {

	Optional<References> findBySize(Integer size);
	
	
	//----------------------- trie (croissant ou decroissant) size et price -------------//
	
	@Query(value = "SELECT u FROM References u Order by u.size Asc")
	List<References> getSizeAsc();
	
	@Query(value = "SELECT u FROM References u Order by u.size Desc")
	List<References> getSizeDesc();
	
	@Query(value = "SELECT u FROM References u Order by u.price Asc")
	List<References> getPriceAsc();
	
	@Query(value = "SELECT u FROM References u Order by u.price Desc")
	List<References> getPriceDesc();
}
