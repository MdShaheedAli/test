package com.example.FileAndMail.FileAndMail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.FileAndMail.FileAndMail.Dao.Attachments;
import com.example.FileAndMail.FileAndMail.Dao.ResponceData;
import com.example.FileAndMail.FileAndMail.Service.HandleFileInter;

@RequestMapping("/file")
@CrossOrigin("*")
@RestController
public class HandleFileController {

	@Autowired
	HandleFileInter handleFileInter;

	@PostMapping("/save")
	public ResponceData saveFile(@RequestParam("file") MultipartFile file) {
		return handleFileInter.saveFile(file); 
	}

	@GetMapping("/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Integer fileId) {

		Attachments attachments = handleFileInter.downloadFile(fileId);

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(attachments.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + attachments.getFileName() + "\"")
				.body(new ByteArrayResource(attachments.getData()));
	}
	
//	@GetMapping(value = "/company/latlngtoaddress/{lat}/{lon}/{companyId}", produces = { "text/plain" })
//	public String getAddressFromLatLng(@PathVariable String lat, @PathVariable String lon,@PathVariable String companyId)
//	{return null;}

}
