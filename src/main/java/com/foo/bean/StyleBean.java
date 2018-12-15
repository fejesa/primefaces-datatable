package com.foo.bean;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import com.foo.data.InstanceStatus;
import com.foo.data.RowType;

@ManagedBean("styleBean")
@ViewScoped
public class StyleBean {

	public String getStatusStyle(InstanceStatus status) {
		switch (status) {
		case EDIT:
			return "edit-status";
		case PENDING:
			return "pending-status";
		case FAILED:
			return "failed-status";
		default:
			return "submitted-status";
		}
	}

	public String getTypeStyle(RowType type) {
		switch (type) {
		case CONFIG:
			return "config-row";
		case ENTITY:
			return "entity-row";
		default:
			return "instance-row";
		}
	}
}
