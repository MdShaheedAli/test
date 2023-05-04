package com.example.FileAndMail.FileAndMail.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FileAndMail.FileAndMail.Dao.Attachments;

public interface AttachmentsRepo extends JpaRepository<Attachments, Integer> {

}
