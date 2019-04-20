package com.epita.fr.quizAJ.DAO;

import org.springframework.stereotype.Repository;

import com.epita.fr.quizAJ.Holders.GenericQueryHolder;
import com.epita.fr.quizAJ.datamodels.QuestionModel;

@Repository
public class QuestionsDAO extends CommonDAO<QuestionModel>
{

	@Override
	public void prepareSearch(QuestionModel criteria, GenericQueryHolder<QuestionModel> holder) {
		// TODO Auto-generated method stub
		holder.setQueryString("from Question as q where q.content like :content"); 
		holder.setClassName(QuestionModel.class);
		holder.putParameter("content", "%" +  criteria.getContent() + "%");
	}

	@Override
	public void authenticateUser(QuestionModel criteria, GenericQueryHolder<QuestionModel> holder) {
		// TODO Auto-generated method stub
		
	}
	
}
