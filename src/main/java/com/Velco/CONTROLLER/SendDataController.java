package com.Velco.CONTROLLER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

	// liste donnee globale et prix pour ordre croissant et decroissant
	List<References> recuperationTous = new ArrayList<>();
	List<Object> refTraitement = new ArrayList<>();
	List<Float> recuperationTousPrix = new ArrayList<>();
	ArrayList<References> saveData = TraitementFichier.saveReferencesRepo();
	List<Integer> recuperationTousSize = new ArrayList<>();

	// -------------------------- recuperation du fichier JSON
	// --------------------//
	@GetMapping("/dataJson")
	public Object SendInputFile() {
		try {
			refTraitement.clear();
			referencesRepo.deleteAll();
			if (refTraitement.isEmpty()) {
				refTraitement.add(TraitementFichier.adressFichier);
				refTraitement.add(TraitementFichier.recuperationDataFile());
				referencesRepo.saveAll(saveData);
				return refTraitement;
			}
		} catch (Exception e) {
			System.err.println("erreur sur le retour controlleur SendInputFile");
		}
		return null;
	}

	// -------------------------- recuperation valeur par clef == size -----------//
	@GetMapping("saveDataTrie/{size}")
	public Optional<References> saveData(@PathVariable Integer size)
			throws NotFoundException, NonUniqueResultException {
		Optional<References> existValue = referencesRepo.findBySize(size);
		try {
			if (!existValue.isPresent() && existValue.isEmpty()) {
				referencesRepo.saveAll(saveData);
			} else {
				System.out.println("La valeur " + size + " existe déjà");
			}
			return referencesRepo.findBySize(size);
		} catch (Exception e) {
			System.err.println("erreur sur le retour controlleur SaveData");
		}
		return null;
	}

	// ------------------------------- trie par prix croissant
	// ---------------------//
	@GetMapping("triePriceAsc")
	public List<Float> triePriceAscendant() {
		try {
			recuperationTous.clear();
			recuperationTousPrix.clear();
			recuperationTousSize.clear();
			if (recuperationTousPrix.isEmpty()) {
				recuperationTous.addAll(referencesRepo.findAll());
				for (int i = 0; i < recuperationTous.size(); i++) {
					recuperationTousPrix.add(recuperationTous.get(i).getPrice());
				}
				Collections.sort(recuperationTousPrix);
				return recuperationTousPrix;
			} else {
				return recuperationTousPrix;
			}

		} catch (Exception e) {
			System.out.println("erreur sur le retour controlleur triePriceAscendant");
		}
		recuperationTousPrix.clear();
		return null;
	}

	// ------------------------------- trie par size decroissant
	// ---------------------//
	@GetMapping("trieSizeDesc")
	public List<Integer> TrieSizeDescendant() {
		try {
			recuperationTous.clear();
			recuperationTousPrix.clear();
			recuperationTousSize.clear();
			if (recuperationTousSize.isEmpty()) {
				recuperationTous.addAll(referencesRepo.findAll());
				for (int i = 0; i < recuperationTous.size(); i++) {
					recuperationTousSize.add(recuperationTous.get(i).getSize());
				}
				Collections.sort(recuperationTousSize, Collections.reverseOrder());
				return recuperationTousSize;
			} else {
				return recuperationTousSize;
			}
		} catch (Exception e) {
			System.out.println("erreur sur le retour controlleur TrieSizeDescendant");
		}
		return null;
	}

}
