package com.firok.springer.entities;

import javax.persistence.Version;

public class BaseEntity{

	@Version
	protected int version;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
