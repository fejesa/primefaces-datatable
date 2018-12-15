package com.foo.bean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import com.foo.data.DataRow;
import com.foo.service.DataService;

@ManagedBean("dashboard")
@RequestScoped
public class DashboardBean {

	private DataService service;
	
	public List<DataRow> getRows() {
		return service.getRows();
	}

	public void setService(DataService service) {
		this.service = service;
	}

	@PostConstruct
	public void init() {
		service = new DataService();
	}
}
