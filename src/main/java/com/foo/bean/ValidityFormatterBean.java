package com.foo.bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean("validityFormatter")
@ViewScoped
public class ValidityFormatterBean {

	private static final ResourceBundle bundle = ResourceBundle.getBundle("i18n");

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

	public String format(Date from, Date to) {

		if (from == null && to == null) {
			return bundle.getString("validUnlimited");
		}
		if (from == null) {
			String s = asString(to);
			return String.format("%s - %s", bundle.getString("validTo"), s);
		}
		if (to == null) {
			String s = asString(from);
			return String.format("%s - %s", bundle.getString("validFrom"), s);
		}

		return String.format("%s-%s", asString(from), asString(to));
	}

	private String asString(Date date) {
		return convertToLocalDate(date).format(formatter);
	}

	private LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
