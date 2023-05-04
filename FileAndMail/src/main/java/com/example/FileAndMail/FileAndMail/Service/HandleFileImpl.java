package com.example.FileAndMail.FileAndMail.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.FileAndMail.FileAndMail.Dao.Attachments;
import com.example.FileAndMail.FileAndMail.Dao.ResponceData;
import com.example.FileAndMail.FileAndMail.Repository.AttachmentsRepo;

@Service
public class HandleFileImpl implements HandleFileInter {

	@Autowired
	AttachmentsRepo attachmentsRepo;

	@Override
	public ResponceData saveFile(MultipartFile file) {
		try {
			Attachments attachments = new Attachments();
			attachments.setFileName(file.getOriginalFilename());
			attachments.setFileType(file.getContentType());
			attachments.setData(file.getBytes());
			attachments = attachmentsRepo.save(attachments);

			String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/file/download/")
					.path(attachments.getId()+"").toUriString();

			ResponceData responceData = new ResponceData();
			responceData.setDownloadUrl(url);
			responceData.setFileName(file.getOriginalFilename());
			responceData.setFileType(file.getContentType());
			responceData.setFileSize(file.getSize());

			return responceData;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Attachments downloadFile(Integer fileId) {
		return attachmentsRepo.findById(fileId).orElse(null);
	}

}
