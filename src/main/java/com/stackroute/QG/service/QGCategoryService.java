package com.stackroute.QG.service;

import java.util.Optional;

import com.stackroute.QG.model.Category;

public interface QGCategoryService {

	/**
	 * Add new Categories 
	 */
	Category addCategory(Category category);
	
	/**
	 * Return all Categories
	 */
	Iterable<Category> findAllCategories();

	/**
	 * find a Cateogy by id
	 */
	Optional<Category> findCategoryId(int categoryId);
	
	/**
	 * find a Cateogy by name
	 */
	Category findByCategoryName(String categoryName);

	/**
	 * delete a category
	 */
	//void delete(int id);

	/**
	 * update a category
	 */
	//Question update(Question question);

	/**
	 * find a question 
	 */
	//List<Question> findByTopicNameAndQuestionLevel(String topicName, int questionLevel);
	

	

}
