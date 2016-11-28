package org.binx.utils.database.memdb.core.generator;

import org.binx.utils.database.memdb.core.model.Line;

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
