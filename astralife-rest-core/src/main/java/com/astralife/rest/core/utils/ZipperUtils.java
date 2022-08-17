package com.astralife.rest.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.assertj.core.util.Files;

public class ZipperUtils {

	public  final String ZIP_EXT = ".zip";
	private static final int BUFFER = 2048;
	
	private String fileName;
	private String filePath;
	/**
	 * @param files : files which to ZIP
	 * @param path : path of ZIP file 
	 * @param fileNameZip : file name of ZIP file WITHOUT EXTENTION
	 * @throws IOException
	 */
	public void zip(List<File> files,String path, String fileNameZip) throws IOException{
		this.fileName = fileNameZip + ZIP_EXT;
		this.filePath = path;
		String fullName = filePath + File.separator + fileName;
		
		BufferedInputStream origin = null;
		FileOutputStream dest = new FileOutputStream(fullName);
		ZipOutputStream out = new ZipOutputStream(
				new BufferedOutputStream(dest));
		byte data[] = new byte[BUFFER];

		for (int i = 0; i < files.size(); i++) {
			FileInputStream fi = new FileInputStream(files.get(i));
			origin = new BufferedInputStream(fi, BUFFER);
			ZipEntry entry = new ZipEntry(files.get(i).getName());
			out.putNextEntry(entry);
			int count;
			while ((count = origin.read(data, 0, BUFFER)) != -1) {
				out.write(data, 0, count);
			}
			origin.close();
			java.nio.file.Files.delete(files.get(i).toPath());
			//DELETE ORIGINAL FILE
			Files.delete(files.get(i));
		}
		out.close();
	}
	public String getFileName() {
		return fileName;
	}
	public String getFilePath() {
		return filePath;
	}

}
