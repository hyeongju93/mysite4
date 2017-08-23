package com.mysite.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public String restore(MultipartFile file) {
		String saveDir="D:\\javastudy\\file\\";
		
		
		//원 파일이름
		String orgName=file.getOriginalFilename();
		System.out.println("OrgName: "+orgName);
		
		//확장자
		String exName=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("ExName: "+exName);
		
		//파일사이즈
		long fileSize=file.getSize();
		System.out.println("SIZE: "+fileSize);
		
		
		//저장파일이음
		String saveName=System.currentTimeMillis()+UUID.randomUUID().toString()+exName;
		System.out.println(saveName);
		
		//파일패스
		String filePath = saveDir+saveName;
		System.out.println(filePath);
		
		// 파일카피
		try {
			
			byte[] fileData = file.getBytes();	//size가 아니고 실제데이터 그림의 배열같은거
			System.out.println("fileData: " + fileData);
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);

			bout.write(fileData);
			if (bout != null) {
				bout.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return saveName;
	}
}
