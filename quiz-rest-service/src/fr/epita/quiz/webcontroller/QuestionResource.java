package fr.epita.quiz.webcontroller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.epita.fr.quizAJ.DAO.QuestionsDAO;
import com.epita.fr.quizAJ.Services.QuizDataService;
import com.epita.fr.quizAJ.datamodels.QuestionModel;



@Path("/questions")
public class QuestionResource {
	
//	@Inject
//	QuizDataService quizServCls;
//	
//	@Inject
//	QuestionsDAO questionDAO;
//
//	@Inject
//	QuestionModel question;
	
	
	@GET
	@Path("/test")
	public String convertCtoF() {
 
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
	
//	@GET
//	@Path("/")
//	@Produces(value = { MediaType.APPLICATION_JSON })
//	public Response findAllQuestions(@QueryParam("s") String inputString) {
//		QuestionModel criteria = new QuestionModel();
//		criteria.setContent(inputString);
//		List<QuestionModel> searchResults = questionDAO.search(criteria);
//		
//		return Response.ok(searchResults).build();
//	}
//	
//	@POST
//	@Path("/")
//	@Consumes(value = { MediaType.APPLICATION_JSON })
//	public Response createQuestion(QuestionModel question) throws URISyntaxException {
//		questionDAO.create(question);
//		return Response.created(URI.create("questions/" + String.valueOf(question.getId()))).build();
//		
//}
	
	

}
