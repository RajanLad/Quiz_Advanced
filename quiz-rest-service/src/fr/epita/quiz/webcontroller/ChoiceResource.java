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

import com.epita.fr.quizAJ.DAO.ChoicesDAO;
import com.epita.fr.quizAJ.DAO.QuestionsDAO;
import com.epita.fr.quizAJ.Services.QuizDataService;
import com.epita.fr.quizAJ.datamodels.ChoiceModel;



@Path("/choices")
public class ChoiceResource {
	
	@Inject
	QuizDataService quizDataService;
	
	@Inject
	ChoicesDAO choiceDAO;

	
	@GET
	@Path("/search")
	@Produces(value = { MediaType.APPLICATION_JSON })
	public Response findAllQuestions(@QueryParam("s") String inputString) {
		ChoiceModel criteria = new ChoiceModel();
		criteria.setChoice_opt(inputString);
		List<ChoiceModel> searchResults = choiceDAO.search(criteria);
		
		return Response.ok(searchResults).build();
	}
	
	@POST
	@Path("/createChoices")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response createQuestion(ChoiceModel choice) throws URISyntaxException {
		choiceDAO.create(choice);
		return Response.created(URI.create("choices/" + String.valueOf(choice.getC_id()))).build();
		
	}
	
	@PUT
	@Path("/updateChoices")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response updateQuestion(ChoiceModel choice) throws URISyntaxException {

		choiceDAO.update(choice);
		
		return Response.ok("The Question ID : "+choice.getC_id()+" got updated").build();
		
	}
	
	@DELETE
	@Path("/deleteChoices")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response deleteQuestion(ChoiceModel choice) throws URISyntaxException {

		choiceDAO.delete(choice);
		
		return Response.ok("The Question ID : "+choice.getC_id()+" got deleted ").build();
		
	}

}
