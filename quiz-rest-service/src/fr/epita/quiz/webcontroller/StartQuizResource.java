package fr.epita.quiz.webcontroller;

import java.net.URI;

import java.util.*;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.epita.fr.quizAJ.DAO.ChoicesDAO;
import com.epita.fr.quizAJ.DAO.QuestionsDAO;
import com.epita.fr.quizAJ.Services.QuizDataService;
import com.epita.fr.quizAJ.datamodels.ChoiceModel;
import com.epita.fr.quizAJ.datamodels.QuestionModel;



@Path("/quiz")
public class StartQuizResource {
	
	@Inject
	QuizDataService quizDataService;
	
	@Inject
	ChoicesDAO choiceDAO;

	@Inject
	QuestionsDAO questionDAO;
	
	@GET
	@Path("/startquiz")
	@Produces(value = { MediaType.APPLICATION_JSON })
	//Since this is a quiz all questions and corresponding choices are collected
	public Response findAllQuestions(@QueryParam("") String inputString) {
		
		HashMap<QuestionModel,List> questionChoiceSet=new HashMap<>();
		
		QuestionModel criteria = new QuestionModel();
		criteria.setContent(inputString);
		
		List<QuestionModel> searchResults = questionDAO.search(criteria);
		
		for(QuestionModel questions : searchResults)
		{
			ChoiceModel ques_reference = new ChoiceModel();
			List<ChoiceModel> choiceResult=choiceDAO.search(ques_reference);
			

				questionChoiceSet.put(questions, choiceResult);
				
		}
		
		return Response.ok(searchResults).build();
	}
	


}