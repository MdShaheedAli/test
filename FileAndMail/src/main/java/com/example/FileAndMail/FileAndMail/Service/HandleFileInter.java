package com.example.FileAndMail.FileAndMail.Service;

import org.springframework.web.multipart.MultipartFile;

import com.example.FileAndMail.FileAndMail.Dao.Attachments;
import com.example.FileAndMail.FileAndMail.Dao.ResponceData;

public interface HandleFileInter {

	ResponceData saveFile(MultipartFile file);

	Attachments downloadFile(Integer fileId);

}
