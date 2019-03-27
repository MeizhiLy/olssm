package com.neuedu.olssm.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.neuedu.olssm.ex.InvalidParamException;
import com.neuedu.olssm.web.ExInfo;

public class FileUtil {
	private static String uploadDir = "/upload";

	public static String fileUpload(HttpServletRequest req, MultipartFile file) {
		String path = req.getServletContext().getRealPath(uploadDir);
		File uploadDirFile = new File(path);
		// ���ļ������ھʹ���һ��
		if (!uploadDirFile.exists()) {
			uploadDirFile.mkdirs();
		}
		// ����Ψһ���ļ���
		String fileName = Long.toString(System.currentTimeMillis());
		// ��ȡ�ļ�����չ��
		int index = file.getOriginalFilename().lastIndexOf(".");
		String surfix = file.getOriginalFilename().substring(index);
		try {
			file.transferTo((new File(path + "/" + fileName + surfix)));
		} catch (IOException e) {
			throw new InvalidParamException(ExInfo.IMG_UPLOAD_ERROR_CODE, ExInfo.IMG_UPLOAD_ERROR_MSG);
		}
		return uploadDir + "/" + fileName + surfix;
	}

}
