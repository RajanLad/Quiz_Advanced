package fr.epita.quiz.webcontroller;


import java.net.URI;
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

import com.epita.fr.quizAJ.DAO.QuestionsDAO;
import com.epita.fr.quizAJ.Services.QuizDataService;
import com.epita.fr.quizAJ.datamodels.ChoiceModel;
import com.epita.fr.quizAJ.datamodels.QuestionModel;



@Path("/questions")
public class QuestionResource {
	
	@Inject
	QuizDataService quizDataService;
	
	@Inject
	QuestionsDAO questionDAO;
	
//	
	
	@GET
	@Path("/test")
	public String convertCtoF() {
 
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}

	
	@GET
	@Path("/search")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response findAllQuestions(@QueryParam("s") String inputString) {
		QuestionModel criteria = new QuestionModel();
		criteria.setContent(inputString);
		List<QuestionModel> searchResults = questionDAO.search(criteria);
		
		return Response.ok(searchResults).build();
	}
	
	@POST
	@Path("/createQuestions")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response createQuestion(QuestionModel question) throws URISyntaxException {
		questionDAO.create(question);
		return Response.created(URI.create("questions/" + String.valueOf(question.getId()))).build();
		
	}
	
	@PUT
	@Path("/updateQuestions")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response updateQuestion(QuestionModel question) throws URISyntaxException {

		questionDAO.update(question);
		
		return Response.ok("The Question ID : "+question.getId()+" got updated").build();
		
	}
	
	@DELETE
	@Path("/deleteQuestions")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response deleteQuestion(QuestionModel question) throws URISyntaxException {

		questionDAO.delete(question);
		
		return Response.ok("The Question ID : "+question.getId()+" got deleted ").build();
		
	}

}
