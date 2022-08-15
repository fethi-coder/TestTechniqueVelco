package com.Velco.TEST;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Velco.MODEL.References;

class globalTest {

//-------------------------- getters setters & constructeur classe References ----------//
	@Test
	void testVerificationGetType() {
		References ref = new References();
		ref.setType("B");
		assertEquals("B", ref.getType());
	}
	
	@Test
	void testVerificationSetSize() {
		References ref = new References();
		ref.setSize(34);
		assertEquals(34, ref.getSize());
	}

	@Test
	void testVerificationSetNumReference() {
		References ref = new References();
		ref.setNumReference(123456789);
		assertEquals(123456789, ref.getNumReference());
	}
	
	@Test
	void testVerificationSetPrice() {
		References ref = new References();
		String conversionFloatPricetest = "34.56";
		ref.setPrice(Float.parseFloat(conversionFloatPricetest));
		assertEquals((float)34.56, ref.getPrice());
	}
	
	@Test
	void testVerificationConstructeurReferences() {
		References constructeurReferences = new References(234543656,"F",(float) 34.56,23);
		assertEquals(234543656,constructeurReferences.getNumReference());
		assertEquals("F", constructeurReferences.getType());
		assertEquals((float)34.56, constructeurReferences.getPrice());
		assertEquals(23, constructeurReferences.getSize());
	}
}
