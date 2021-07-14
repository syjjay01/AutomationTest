package com.libarary.Base;

import com.libarary.Base.Enum.ByType;

public class Locator {

	private String element;
	// default is 5 sec
	private int waitSec = 5;
	private ByType byType;
	
	public Locator() {

	}
	/**
	 * defaut Locator ,use id
	 * 
	 * @author Young
	 * @param element
	 */
	public Locator(String element) {
        this.element = element;
		this.waitSec = 3;
		this.byType = ByType.id;
	}

	public Locator(String element, int waitSec) {
		this.waitSec = waitSec;
		this.element = element;
		this.byType = ByType.id;
	}

	public Locator(String element, int waitSec, ByType byType) {
		this.waitSec = waitSec;
		this.element = element;
		this.byType = byType;
	}

	public String getElement() {
		return element;
	}

	public int getWaitSec() {
		return waitSec;
	}

	public ByType getBy() {
		return byType;
	}

	public void setBy(ByType byType) {
		this.byType = byType;
	}

//	public void setReplace(String rep, String rex) {
//		StringTools.replaceAll(element, rex, rep);
//	}
}
