package com.Velco.TEST;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.Velco.MODEL.References;

class globalTest {


	@Test
	void testVerificationGetType() {
		References ref = new References();
		ref.setType("B");
		assertEquals("B", ref.getType());
	}
	
	@Test
	void testVerificationGetSize() {
		References ref = new References();
		ref.setSize(34);
		assertEquals(34, ref.getSize());
	}

}
