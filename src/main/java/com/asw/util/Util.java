package com.asw.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

	public static String toCsv(List<String> values) {
		return values == null || values.isEmpty() ? null
				: values.stream().map(v -> v.trim().toLowerCase()).collect(Collectors.joining(","));
	}

	public static List<String> toList(String csv) {
		List<String> out = new ArrayList<>();
		if (csv != null) {
			for (String tag : csv.split(",")) {
				out.add(tag.toLowerCase().trim());
			}
		}
		return out;
	}

	public static String addString(String newString, String csv) {
		List<String> list = toList(csv);
		list.add(newString);
		return toCsv(list);
	}

	public static String deleteString(String stringToDelete, String csv) {
		List<String> list = toList(csv);
		list.remove(stringToDelete);
		return toCsv(list);
	}

	public static String toJsonArray(String csv) {
		return "[" + toList(csv).stream().map(f -> "\"" + f + "\"").collect(Collectors.joining(",")) + "]";
	}

}
