package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class LineGenerator {

	public static Line getLine() {
		return new Line();
	}
}
