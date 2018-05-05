package com.stackroute.QG.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "structuredQuestion")
public class Category {

	private int categoryId;
	private String categoryName;
	private List<Topic> topic;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Topic> getTopic() {
		return topic;
	}

	public void setTopic(List<Topic> topic) {
		this.topic = topic;
	}

	public Category(int categoryId, String categoryName, List<Topic> topic) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.topic = topic;
	}

	public Category() {

	}

}
