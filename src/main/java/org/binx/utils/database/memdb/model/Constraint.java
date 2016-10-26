package org.binx.utils.database.memdb.model;

import java.io.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Constraint  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private ContraintType type;
	
	public Constraint(String name, ContraintType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContraintType getType() {
		return type;
	}
}
