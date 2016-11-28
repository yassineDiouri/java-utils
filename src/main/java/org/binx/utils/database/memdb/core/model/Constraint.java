package org.binx.utils.database.memdb.core.model;

import java.io.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Constraint  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private ConstraintType type;
	
	public Constraint(String name, ConstraintType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConstraintType getType() {
		return type;
	}
}
