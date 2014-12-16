package org.mihaylov.furniture.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileSystemUtils {

	public static String saveMultipart(MultipartFile file, String folder)
			throws IOException {
		byte[] bytes = file.getBytes();
		String path = String.format("D:\\tmp\\img\\%s\\%d_%s", folder,
				System.currentTimeMillis(), file.getOriginalFilename());
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path)));
		stream.write(bytes);
		stream.close();
		return path;
	}
}
