package com.study.mystudy.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MyUtils {
	public static String toJson(Object o) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
		ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
		try {
			String json = writer.writeValueAsString(o);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "변환실패";
		}
	}
}
