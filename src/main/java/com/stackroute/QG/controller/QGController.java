package com.stackroute.QG.controller;

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

import com.stackroute.QG.model.Question;
import com.stackroute.QG.service.QGService;

@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/question-generator")
@RestController
public class QGController {

	@Autowired
	private QGService qGRedisService;

	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		Question newQuestion = qGRedisService.addQuestion(question);
		return new ResponseEntity<Question>(newQuestion, HttpStatus.OK);
	}

	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Question>> getAllQuestions(Question question) {
		Iterable<Question> allQuestions = qGRedisService.findAllQuestions();
		return new ResponseEntity<Iterable<Question>>(allQuestions, HttpStatus.OK);
	}

	  @RequestMapping(value = "/questiontopic/{topicName}/{questionLevel}", method =RequestMethod.GET) 
	  public ResponseEntity<List<Question>> findByTopicNameAndQuestionLevel(@PathVariable(value = "topicName") String topicName, @PathVariable(value = "questionLevel") int questionLevel) {
	  List<Question> questionByTopic = qGRedisService.findByTopicNameAndQuestionLevel(topicName, questionLevel);
	  System.out.println(questionByTopic);
	  return new ResponseEntity<List<Question>>(questionByTopic, HttpStatus.OK); 
	  }

	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Question>> findById(@PathVariable(value = "questionId") int questionId) {
		Optional<Question> foundQuestion = qGRedisService.findQuestion(questionId);
		return new ResponseEntity<Optional<Question>>(foundQuestion, HttpStatus.OK);
	}

	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Question> deleteById(@PathVariable(value = "questionId") int questionId) {
		qGRedisService.delete(questionId);
		return new ResponseEntity<Question>(HttpStatus.OK);
	}

	@RequestMapping(value = "/question/{questionId}", method = RequestMethod.PUT)
	public ResponseEntity<Question> updateById(@PathVariable(value = "questionId") int questionId,
			@RequestBody Question question) {
		Question updatedQuestion = qGRedisService.update(question);
		return new ResponseEntity<Question>(updatedQuestion, HttpStatus.OK);
	}
}