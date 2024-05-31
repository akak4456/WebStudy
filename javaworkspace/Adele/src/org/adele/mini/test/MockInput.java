package org.adele.mini.test;

import org.adele.mini.gameinput.GameInput;

public class MockInput implements GameInput {
	
	private int nextIntVal;
	private String nextVal;
	private String nextLineVal;
	
	public MockInput() {
		nextIntVal = 1;
		nextVal = "Y";
		nextLineVal = "Y";
	}

	@Override
	public int nextInt() {
		return nextIntVal;
	}

	@Override
	public String nextLine() {
		return nextLineVal;
	}

}
