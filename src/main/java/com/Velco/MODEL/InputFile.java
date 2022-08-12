package com.Velco.MODEL;

import java.util.List;

public class InputFile {
	
	List<References> references;
	Errors  errors;
	public InputFile() {
		super();
	}

	public InputFile(List<References> references, Errors errors) {
		super();
		this.references = references;
		this.errors = errors;
	}

	public List<References> getReferences() {
		return references;
	}

	public void setReferences(List<References> references) {
		this.references = references;
	}

	public Errors getErrors() {
		return errors;
	}

	public void setErrors(Errors errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "InputFile [references=" + references + ", errors=" + errors + "]";
	}
	


}
