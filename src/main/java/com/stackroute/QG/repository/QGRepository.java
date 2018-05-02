package com.stackroute.QG.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.QG.model.Question;

@Repository
public interface QGRepository extends CrudRepository<Question, Object> {
	
	  List<Question> findByTopicNameAndQuestionLevel(String topicName, int questionlevel);

//	    @Query("{domain: { $regex: ?0 } })")
//	    List<Question> findByTopiNameAndQuestionLevel(String domain);
	
//	    @Query("{ 'topicName' : ?0  , 'questionLevel' :?0}")
//	List<Question> findByTopiNameAndQuestionLevel(String topicName, int questionLevel);
}
