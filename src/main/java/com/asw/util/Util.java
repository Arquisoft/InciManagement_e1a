package com.asw.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.asw.entities.Incidence;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

	private static ObjectMapper mapper;

	public static String addString(String newString, String csv) {
		List<String> list = toList(csv);
		list.add(newString);
		return toCsv(list);
	}

	public static String deleteProperty(String key, String properties) {
		Map<String, String> map = toMap(properties);
		map.remove(key);
		return toCsp(map);
	}

	public static String deleteString(String stringToDelete, String csv) {
		List<String> list = toList(csv);
		list.remove(stringToDelete);
		return toCsv(list);
	}

	public static ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
		}
		return mapper;
	}

	public static String IncidenceToJSON(Incidence incidence) {
		try {
			return getMapper().writeValueAsString(incidence);
		} catch (JsonProcessingException e) {

		}
		return null;
	}

	public static Incidence JsonToIncidence(String JSON) {
		try {
			return getMapper().readValue(JSON, Incidence.class);
		} catch (IOException e) {

		}
		return null;
	}

	public static String toCsp(Map<String, String> properyMap) {
		List<String> propertyList = new ArrayList<>();
		for (String key : properyMap.keySet()) {
			propertyList.add(key + ":" + properyMap.get(key));
		}
		return toCsv(propertyList);
	}

	public static String toCsv(List<String> values) {
		return values != null && !values.isEmpty() 
				? values.stream().map(v -> v.trim().toLowerCase()).collect(Collectors.joining(","))
				: null;
	}

	public static String toJsonArray(String csv) {
		return "[" + toList(csv).stream().map(f -> "\"" + f + "\"").collect(Collectors.joining(",")) + "]";
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

	public static Map<String, String> toMap(String csp) {
		Map<String, String> out = new HashMap<>();
		for (String property : csp.split(",")) {
			if (property.contains(":")) {
				out.put(property.split(":")[0].trim(), property.split(":")[1].trim());
			}
		}
		return out;
	}

}
