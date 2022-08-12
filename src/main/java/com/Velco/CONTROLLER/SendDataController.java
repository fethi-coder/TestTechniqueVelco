package com.Velco.CONTROLLER;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Velco.METHODE.TraitementFichier;
import com.Velco.MODEL.References;
import com.Velco.REPOSITORY.ReferencesRepository;

@RestController
@CrossOrigin(".")
@RequestMapping("/velco")
public class SendDataController {

	
	@Autowired
	ReferencesRepository referencesRepo;
	
	
	//-------------------------- recuperation du fichier JSON --------------------//
	@GetMapping("/dataJson")
	public Object SendInputFile() {
		List<Object> refTraitement = new ArrayList<>();
	refTraitement.add(TraitementFichier.adressFichier);
	refTraitement.add(TraitementFichier.recuperationDataFile());
	return refTraitement;
	}
	
	
	//-------------------------- recuperation valeur par clef == size -----------//
	@GetMapping("saveDataTrie/{size}")
	public Optional<References> saveData(@PathVariable Integer size) {
		Optional<References> existValue = referencesRepo.findBySize(size);
		if(!existValue.isPresent()) {
			ArrayList<References> saveData = TraitementFichier.saveReferencesRepo();
			referencesRepo.saveAll(saveData);	
		}else {
			System.out.println("La valeur "+ size +" existe déjà" );
		}
			return referencesRepo.findBySize(size);
	}
}
