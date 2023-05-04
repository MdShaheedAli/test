/**
 * 
 */
package com.example.FileAndMail.FileAndMail.Dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author admin
 *
 */

@Entity
@Data
@Table(name="tbl_attachments")
public class Attachments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "file_Name",length =50,nullable = false)
	String fileName;
	
	@Column(name = "file_Type",length =50,nullable = false)
	String fileType;
	
	@Lob
	@Column(name = "data",nullable = false)
	byte data[];

}
