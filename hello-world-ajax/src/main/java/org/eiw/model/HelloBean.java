package org.eiw.model;

/**
 * Dans un cas réel, ce bean pourrait être un objet persistant.
 * @author yan
 *
 */
public class HelloBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloBean [name=" + name + "]";
	}
	
}
