package com.astralife.rest.core.utils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class Base64Util {

	public static synchronized File toFile(String base64source, String fileNameWithPath) throws IOException {

		// create output file
		File outputFile = new File(fileNameWithPath);

		// decode the string and write to file
		byte[] decodedBytes = Base64.getDecoder().decode(base64source);
		FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
		return outputFile;

	}

	public static synchronized String fromFile(File file) throws IOException {
		
		byte[] fileContent = FileUtils.readFileToByteArray(file);

		// encode the file to Base64
		return Base64.getEncoder().encodeToString(fileContent);
	}
	
}
