package com.stackroute.QG.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.QG.model.Category;

@Repository
public interface QGCategoryRepository extends CrudRepository<Category, Object> {

	// List<Question> findByTopicNameAndQuestionLevel(String topicName, int questionlevel);

	// @Query("{ 'categoryName' : ?0 }")
	// List<Question> findByTopiNameAndQuestionLevel(String categoryName);

	Category findByCategoryName(String categoryName);
}
