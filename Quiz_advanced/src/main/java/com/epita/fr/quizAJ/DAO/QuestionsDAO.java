package com.epita.fr.quizAJ.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.epita.fr.quizAJ.Holders.GenericQueryHolder;
import com.epita.fr.quizAJ.Services.QuizDataService;
import com.epita.fr.quizAJ.datamodels.QuestionModel;

@Repository
public class QuestionsDAO extends CommonDAO<QuestionModel>
{

	private static final Logger LOGGER = LogManager.getLogger(QuestionsDAO.class); 
	@Override
	public void prepareSearch(QuestionModel criteria, GenericQueryHolder<QuestionModel> holder) {
		// TODO Auto-generated method stub
		LOGGER.info("entering the create method");
		holder.setQueryString("from Question as q where q.content like :content"); 
		holder.setClassName(QuestionModel.class);
		holder.putParameter("content", "%" +  criteria.getContent() + "%");
	}

	@Override
	public void authenticateUser(QuestionModel criteria, GenericQueryHolder<QuestionModel> holder) {
		// TODO Auto-generated method stub
		
	}
	
}
