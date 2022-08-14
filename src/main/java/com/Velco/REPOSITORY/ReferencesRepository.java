package com.Velco.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Velco.MODEL.References;

@Repository
public interface ReferencesRepository extends JpaRepository<References, Long> {

	Optional<References> findBySize(Integer size);

}
