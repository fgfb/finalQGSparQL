package com.stackroute.QG.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.QG.model.Category;
import com.stackroute.QG.repository.QGCategoryRepository;

@Service
public class QGCategoryServiceImpl implements QGCategoryService {

	@Autowired
	private QGCategoryRepository qGRedisRepository;

	@PostConstruct
	private void initDataBase() {
		/*
		 * qGRedisRepository.save(new Question(1, 1001, "Computers", 101, "Java", 3,
		 * "what is java", "public", "private", "default", "protected", "default"));
		 * qGRedisRepository.save(new Question(2, 1001, "Computers", 101, "Java", 1,
		 * "what is constructor?", "anything", "In class", "destructor",
		 * "none of the above", "none of the above")); qGRedisRepository.save( new
		 * Question(3, 1001, "Computers", 101, "Java", 2, "what is class?", "java", "c",
		 * "c++", "c#", "java")); qGRedisRepository.save(new Question(4, 1001,
		 * "Computers", 102, "Spring", 3, "what is spring?", "interface",
		 * "servelet Context", "properties", "XML", "servelet Context"));
		 * qGRedisRepository.save(new Question(5, 1001, "Computers", 102, "Spring", 2,
		 * "what is interface?", "abstarct", "static", "final", "none", "none"));
		 * qGRedisRepository.save(new Question(6, 1001, "Computers", 102, "Spring", 2,
		 * "what is objects?", "memomy", "instance", "nothing", "all the above",
		 * "nothing")); qGRedisRepository.save(new Question(7, 1001, "Computers", 102,
		 * "Spring", 1, "what is xml?", "file", "folder", "node", "none", "file"));
		 */

		// qGRedisRepository.save(new Category(1, "sports", 32, "IPL", 1, 3, "what is
		// IPL?", "sdjksd", "hgadsag", "ghsd", "yushj", "hsdjh", 234, "hgsdas" ));
	}

	@Override
	public Category addCategory(Category category) {
		qGRedisRepository.save(category);
		return category;
	}

	@Override
	public Iterable<Category> findAllCategories() {
		Iterable<Category> categoryList = qGRedisRepository.findAll();
		return categoryList;
	}

	@Override
	public Optional<Category> findCategoryId(int categoryId) {
		Optional<Category> foundCategory = qGRedisRepository.findById(categoryId);
		return foundCategory;
	}

	@Override
	public Category findByCategoryName(String categoryName) {
		Category foundByCategoryName = qGRedisRepository.findByCategoryName(categoryName);
		return foundByCategoryName;
	}
	

	// @Override
	// public Iterable<Category> findAllQuestions() {
	// Iterable<Category> questionsList = qGRedisRepository.findAll();
	// return questionsList;
	// }
	//
	// @Override
	// public Category addQuestion(Category category) {
	// qGRedisRepository.save(category);
	// return category;
	// }

	// @Override
	// public Optional<Question> findQuestion(int id) {
	// Optional<Question> foundQuestion = qGRedisRepository.findById(id);
	// return foundQuestion;
	// }

	// @Override
	// public void delete(int id) {
	// qGRedisRepository.deleteByCategoryId(id);
	// }

	// @Override
	// public Question update(Question question) {
	// Question updatedQuestion = (Question) qGRedisRepository.save(question);
	// return updatedQuestion;
	// }

	// @Override
	// public List<Question> findByTopicNameAndQuestionLevel(String topicName, int
	// questionLevel) {
	// List<Question> questionsByTopic =
	// qGRedisRepository.findByTopicNameAndQuestionLevel(topicName, questionLevel);
	// return questionsByTopic;
	// }
}