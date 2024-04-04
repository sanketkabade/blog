package com.blogg;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Blogging {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String title;
	String subTitle;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] image;
	String details;
	
	public Blogging() {
		// TODO Auto-generated constructor stub
	}

	public Blogging(int id, String name, String title, String subTitle, byte[] image, String details) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.subTitle = subTitle;
		this.image = image;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Blogging [id=" + id + ", name=" + name + ", title=" + title + ", subTitle=" + subTitle + ", image="
				+ Arrays.toString(image) + ", details=" + details + "]";
	}

}
