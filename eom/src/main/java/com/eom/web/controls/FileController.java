package com.eom.web.controls;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@Autowired
	//@Qualifier("servletContext") // 만약 같은 타입의 객체가 여러 개일 경우, 이름 지정
	ServletContext application;
	
	@RequestMapping(value="/file/upload", method=RequestMethod.GET)
	public String uploadForm() {
		return "/file/UploadForm2.html";
	}
	
	@RequestMapping(value="/file/upload", method=RequestMethod.POST)
	public String upload(
			String carModel, String cc,
			@RequestParam MultipartFile photo1,
			@RequestParam MultipartFile photo2,
			ModelMap model) throws Exception {
		
		String basePath = application.getRealPath("/file") + "/";
		
		String fileName = newFileName();
		File file = new File(basePath + fileName);
		photo1.transferTo(file);
		
		model.addAttribute("photo1OriginFileName", photo1.getOriginalFilename());
		model.addAttribute("photo1NewFileName", fileName);
		
		fileName = newFileName();
		file = new File(basePath + fileName);
		photo2.transferTo(file);
		
		model.addAttribute("photo2OriginFileName", photo2.getOriginalFilename());
		model.addAttribute("photo2NewFileName", fileName);
		
		return "/file/upload2.jsp";
	}

	private String newFileName() {
		return "upload_" + 
				System.currentTimeMillis() + "_" +
				Math.random();
	}
}







