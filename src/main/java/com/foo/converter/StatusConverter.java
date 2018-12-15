package com.foo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.foo.data.InstanceStatus;

@FacesConverter(value = "statusConverter")
public class StatusConverter implements Converter<InstanceStatus> {

	@Override
	public InstanceStatus getAsObject(FacesContext context, UIComponent component, String value) {
		return InstanceStatus.valueOf(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, InstanceStatus value) {
		return value == null ? "" : EnumsI18Converter.getEnumString(value);
	}
}