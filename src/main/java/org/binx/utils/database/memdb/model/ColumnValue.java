package org.binx.utils.database.memdb.model;

import java.io.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class ColumnValue  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long index;
	private Integer order;
	private Object value;
	
	public ColumnValue() {
		this.value = null;
	}
	
	public ColumnValue(Object value) {
		this.value = value;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
