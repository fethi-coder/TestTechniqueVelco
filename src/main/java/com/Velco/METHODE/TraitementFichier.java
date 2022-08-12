package com.Velco.METHODE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.Velco.MODEL.Errors;
import com.Velco.MODEL.InputFile;
import com.Velco.MODEL.References;

public class TraitementFichier {
	

	//...traitement du fichier et construction du retour de l'appel du controller au format JSON
	
public final static String adressFichier = "Ref_07102014.txt";
static ArrayList<References> resultData = new ArrayList<>();

public static Object recuperationDataFile() {
	
//--------------- recuperation donnee du fichier .txt -------------------//	
	File file = new File(adressFichier);
	@SuppressWarnings("unused")
	ArrayList<Object> finalData = new ArrayList<>();
	
	try {
		FileReader filereader = new FileReader(file);
		BufferedReader br = new BufferedReader(filereader);
		String line;
	while((line = br.readLine()) != null){
		ajouterData(resultData, line);	
	}
	br.close();
		
	} catch (FileNotFoundException e) {
		System.err.println("le fichier n'existe pas");
	} catch (IOException e) {
		System.err.println("lecture du fichier impossible");
		e.printStackTrace();
	}		
	return conditionDeTrie(resultData);
}


//------------------------ajoute des datas dans la class reference --------------------//
public static ArrayList<References> ajouterData(ArrayList<References> resultData, String line) {
	String[] data = line.split(";");
	resultData.add(new References(Integer.parseInt(data[0]),data[1],Float.parseFloat(data[2]),Integer.parseInt(data[3])));
	return resultData;
}



//----------------------- condition de trie du fichier JSON ----------------------------//
private static Object conditionDeTrie(ArrayList<References> resultData) {
	InputFile globalDataTraitement = new InputFile();
	ArrayList<References> goodValue = new ArrayList<>();
	for (int i = 0; i < resultData.size(); i++) {
		if (resultData.get(i).getType().equals("R") || resultData.get(i).getType().equals("G") ||  resultData.get(i).getType().equals("B")) {
			goodValue.add(resultData.get(i));
			globalDataTraitement.setReferences(goodValue);
		} else{
		Errors erreur = new Errors();
		erreur.setLine(resultData.size());
		erreur.setMessage("Incorrect value for color");
		erreur.setValue(resultData.get(i));
		globalDataTraitement.setErrors(erreur);
		}
	}
	return globalDataTraitement;
}

//----------------- traitement pour enregistremant en base de donnee ---------------------//
public static ArrayList<References> saveReferencesRepo() {
	return resultData;
}
}
