package com.stackroute.QG.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "qntopic")
public class Topic {

	private int topicId;
	@Id
	private String topicName;
	private List<Questions> questions;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestionStem(List<Questions> questions) {
		this.questions = questions;
	}

	public Topic(int topicId, String topicName, List<Questions> questions) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.questions = questions;
	}

	public Topic() {

	}
}
