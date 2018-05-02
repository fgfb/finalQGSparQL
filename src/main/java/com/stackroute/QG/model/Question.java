package com.stackroute.QG.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "question")
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "id cannot be null")
	@Id
	private int questionId;
	@NotNull(message = "topic-id cannot be null")
	private int topicId;
	@NotNull(message = "topic name cannot be null")
	private String topicName;
	@NotNull(message = "category id cannot be null")
	private int categoryId;
	@NotNull(message = "category name cannot be null")
	private String categoryName;
	@NotNull(message = "provide the level of the question")
	private int questionLevel;
	@NotNull(message = "question cannot be null")
	private String question;
	@NotNull(message = "provide options to your ans")
	private String option1;
	@NotNull(message = "provide options to your ans")
	private String option2;
	@NotNull(message = "provide options to your ans")
	private String option3;
	@NotNull(message = "provide options to your ans")
	private String option4;
	@NotNull(message = "you need to provide correct answer")
	private String correctAnswer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

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

	public int getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question() {

	}

	public Question(int questionId, int categoryId, String categoryName, int topicId, String topicName,
			int questionLevel, String question, String option1, String option2, String option3, String option4,
			String correctAnswer) {
		super();
		this.questionId = questionId;
		this.topicId = topicId;
		this.topicName = topicName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.questionLevel = questionLevel;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
	}
}
