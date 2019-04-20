package com.epita.fr.quizAJ.DAO;

import org.springframework.stereotype.Repository;

import com.epita.fr.quizAJ.Holders.GenericQueryHolder;
import com.epita.fr.quizAJ.datamodels.ChoiceModel;

@Repository
public class ChoicesDAO extends CommonDAO<ChoiceModel>
{

	@Override
	public void prepareSearch(ChoiceModel criteria, GenericQueryHolder<ChoiceModel> holder) {
		// TODO Auto-generated method stub
		holder.setQueryString("from Choice as choice where choice.question = :question");
		holder.setClassName(ChoiceModel.class);
		holder.putParameter("question", criteria.getQuestionReference());
	}

	@Override
	public void authenticateUser(ChoiceModel criteria, GenericQueryHolder<ChoiceModel> holder) {
		// TODO Auto-generated method stub
		
	}

}
