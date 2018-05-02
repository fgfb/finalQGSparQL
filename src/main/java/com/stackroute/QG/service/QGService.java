package com.stackroute.QG.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.QG.model.Question;

public interface QGService {

	/**
	 * Return all questions
	 */
	Iterable<Question> findAllQuestions();

	/**
	 * Add key-value pair to Redis.
	 */
	Question addQuestion(Question question);

	/**
	 * find a question
	 */
	Optional<Question> findQuestion(int id);

	/**
	 * delete a question
	 */
	void delete(int id);

	/**
	 * update a question
	 */
	Question update(Question question);

	/**
	 * find a question by topic
	 */
	List<Question> findByTopicNameAndQuestionLevel(String topicName, int questionLevel);

}
