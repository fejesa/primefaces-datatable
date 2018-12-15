package com.foo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.foo.data.DataRow;
import com.foo.data.InstanceStatus;
import com.foo.data.RowType;

public class DataService {

	private Random random = new Random();

	public List<DataRow> getRows() {

		List<DataRow> rows = new ArrayList<>();
		rows.addAll(entities("First Entity"));
		rows.addAll(entities("Second Entity"));

		return rows;
	}

	private List<DataRow> entities(String name) {
		List<DataRow> rows = new ArrayList<>();
		rows.add(entity(name));

		for (DataRow row : configs()) {
			rows.add(row);
			rows.addAll(instances(row.getName()));
		}

		return rows;
	}

	private DataRow entity(String name) {
		DataRow row = new DataRow();
		row.setType(RowType.ENTITY);
		row.setName(name);

		return row;
	}

	public List<DataRow> configs() {
		int number = random.nextInt(3) + 1;
		return IntStream.range(0, number).mapToObj(this::config).sorted(Comparator.comparing(DataRow::getName))
				.collect(Collectors.toList());
	}

	private DataRow config(int i) {
		DataRow row = new DataRow();
		row.setDateFrom(random.nextBoolean() ? new Date() : null);
		row.setDateTo(random.nextBoolean() ? new Date() : null);
		row.setType(RowType.CONFIG);
		
	    RandomString randomString = new RandomString(random.nextInt(25) + 5, random);
		row.setName(randomString.nextString());
		
		return row;
	}

	private List<DataRow> instances(String name) {
		int number = random.nextInt(5);
		return IntStream.range(0, number).mapToObj(i -> instance(name, i))
				.sorted(Comparator.comparing(DataRow::getName)).collect(Collectors.toList());
	}

	private DataRow instance(String name, int id) {
		DataRow row = new DataRow();
		row.setName(String.format("%s #%d", name, id));
		row.setModificationTime(new Date());
		row.setModifiedBy("First Last");
		row.setType(RowType.INSTANCE);

		InstanceStatus[] statuses = InstanceStatus.values();
		int index = random.nextInt(statuses.length);
		row.setStatus(statuses[index]);
		return row;
	}
}
