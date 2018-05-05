package com.stackroute.QG.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.QG.model.Category;
import com.stackroute.QG.model.Questions;
import com.stackroute.QG.model.Topic;
import com.stackroute.QG.service.QGCategoryService;

@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/question-generator")
@RestController
public class QGCategoryController {

	@Autowired
	private QGCategoryService qGCategoryService;

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category newCategory = qGCategoryService.addCategory(category);
		return new ResponseEntity<Category>(newCategory, HttpStatus.OK);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Category>> getAllCategories(Category category) {
		Iterable<Category> allCategories = qGCategoryService.findAllCategories();
		return new ResponseEntity<Iterable<Category>>(allCategories, HttpStatus.OK);
	}

	@RequestMapping(value = "/categoryId/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Category>> findByCategoryId(@PathVariable(value = "categoryId") int categoryId) {
		Optional<Category> foundCategoryById = qGCategoryService.findCategoryId(categoryId);
		return new ResponseEntity<Optional<Category>>(foundCategoryById, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryName}", method = RequestMethod.GET)
	public ResponseEntity<Category> findByCategoryName(@PathVariable(value = "categoryName") String categoryName) {
		Category foundCategoryByName = qGCategoryService.findByCategoryName(categoryName);
		return new ResponseEntity<Category>(foundCategoryByName, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryName}/topics", method = RequestMethod.GET)
	public ResponseEntity<List<Topic>> findTopicsUnderACategory(
			@PathVariable(value = "categoryName") String categoryName) {
		Category foundCategoryByName = qGCategoryService.findByCategoryName(categoryName);
		Iterator<Topic> itr = foundCategoryByName.getTopic().iterator();
		List<Topic> topics = new ArrayList<>();

		while (itr.hasNext()) {
			Topic str = itr.next();
			topics.add(str);
		}
		return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryName}/{topicName}", method = RequestMethod.GET)
	public ResponseEntity<List<Topic>> findByTopicNameUnderACategory(
			@PathVariable(value = "categoryName") String categoryName,
			@PathVariable(value = "topicName") String topicName) {
		Category foundCategoryByName = qGCategoryService.findByCategoryName(categoryName);
		Iterator<Topic> itr = foundCategoryByName.getTopic().iterator();
		List<Topic> topics = new ArrayList<>();
		while (itr.hasNext()) {
			Topic str = itr.next();
			if (str.getTopicName().equalsIgnoreCase(topicName)) {
				topics.add(str);
			}
		}
		return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryName}/{topicName}/{questionId}", method = RequestMethod.GET)
	public ResponseEntity<Questions> findAQuestionByIdUnderATopic(
			@PathVariable(value = "categoryName") String categoryName,
			@PathVariable(value = "topicName") String topicName,
			@PathVariable(value = "questionId") String questionId) {
		Category foundCategoryByName = qGCategoryService.findByCategoryName(categoryName);
		Iterator<Topic> itr = foundCategoryByName.getTopic().iterator();
		Questions str1 = null;
		while (itr.hasNext()) {
			Topic topicStr = itr.next();
			if (topicStr.getTopicName().equalsIgnoreCase(topicName)) {
				Iterator<Questions> str = topicStr.getQuestions().iterator();
				str1 = str.next();
			}
		}
		return new ResponseEntity<Questions>(str1, HttpStatus.OK);
	}

	// @RequestMapping(value = "/questiontopic/{topicName}/{questionLevel}", method
	// =RequestMethod.GET)
	// public ResponseEntity<List<Question>>
	// findByTopicNameAndQuestionLevel(@PathVariable(value = "topicName") String
	// topicName, @PathVariable(value = "questionLevel") int questionLevel) {
	// List<Question> questionByTopic =
	// qGRedisService.findByTopicNameAndQuestionLevel(topicName, questionLevel);
	// System.out.println(questionByTopic);
	// return new ResponseEntity<List<Question>>(questionByTopic, HttpStatus.OK);
	// }

	// @RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
	// public ResponseEntity<Optional<Question>> findById(@PathVariable(value =
	// "questionId") int questionId) {
	// Optional<Question> foundQuestion = qGRedisService.findQuestion(questionId);
	// return new ResponseEntity<Optional<Question>>(foundQuestion, HttpStatus.OK);
	// }

	// @RequestMapping(value = "/question/{categoryId}", method =
	// RequestMethod.DELETE)
	// public ResponseEntity<Question> deleteById(@PathVariable(value =
	// "categoryId") int categoryId) {
	// qGRedisService.delete(categoryId);
	// return new ResponseEntity<Question>(HttpStatus.OK);
	// }

	// @RequestMapping(value = "/question/{questionId}", method = RequestMethod.PUT)
	// public ResponseEntity<Question> updateById(@PathVariable(value =
	// "questionId") int questionId,
	// @RequestBody Question question) {
	// Question updatedQuestion = qGRedisService.update(question);
	// return new ResponseEntity<Question>(updatedQuestion, HttpStatus.OK);
	// }

}