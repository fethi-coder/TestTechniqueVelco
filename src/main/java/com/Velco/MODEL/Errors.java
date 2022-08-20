package com.Velco.MODEL;

import java.util.List;

public class Errors {

	private Integer line;
	private String message;
	private List<References> value;

	public Errors() {
		super();
	}

	public Errors(Integer line, String message, List<References> value) {
		super();
		this.line = line;
		this.message = message;
		this.value = value;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<References> getValue() {
		return value;
	}

	public void setValue(List<References> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Errors [line=" + line + ", message=" + message + ", value=" + value + "]";
	}

}
