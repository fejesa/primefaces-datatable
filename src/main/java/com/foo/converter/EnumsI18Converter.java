package com.foo.converter;

import java.util.ResourceBundle;

public class EnumsI18Converter {

	public static <E extends Enum<E>> String getEnumString(E e) {
		return ResourceBundle.getBundle("Enums").getString(e.name());
	}
}
