 package com.epita.fr.quizAJ.Services;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.epita.fr.quizAJ.DAO.ChoicesDAO;
import com.epita.fr.quizAJ.DAO.ProfessorDAO;
import com.epita.fr.quizAJ.DAO.QuestionsDAO;
import com.epita.fr.quizAJ.DAO.StudentDAO;
import com.epita.fr.quizAJ.datamodels.ChoiceModel;
import com.epita.fr.quizAJ.datamodels.QuestionModel;

@Repository
public class QuizDataService 
{
	private static final Logger LOGGER = LogManager.getLogger(QuizDataService.class); 
	
	@Inject
	QuestionsDAO questionDAO;
	
	@Inject
	ChoicesDAO choiceDAO;
	
	@Inject
	ProfessorDAO professorDAO;
	
	@Inject
	StudentDAO studentDAO;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional(Transactional.TxType.REQUIRED)
	public void createQuestionAndChoices(QuestionModel question, ChoiceModel... choices) {
		
		LOGGER.info("entering the createQuestionAndChoices method");
			questionDAO.create(question);
		for (ChoiceModel choice : choices) {
			choice.setQuestionReference(question);
			choiceDAO.create(choice);
		}
	}
}
