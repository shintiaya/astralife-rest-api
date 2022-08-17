package com.astralife.rest.core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

public class JsonUtil<T extends Object> {

	public T fromJson(String jsonFilePath, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		InputStream inputStream = TypeReference.class.getResourceAsStream(jsonFilePath);
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){	
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
		}
		Gson gson = new Gson();
		System.out.println(stringBuilder.toString());
				
		return gson.fromJson(stringBuilder.toString(), clazz);
	}
}
