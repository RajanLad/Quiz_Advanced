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

import com.epita.fr.quizAJ.DAO.ProfessorDAO;
import com.epita.fr.quizAJ.DAO.QuestionsDAO;
import com.epita.fr.quizAJ.DAO.StudentDAO;
import com.epita.fr.quizAJ.Services.QuizDataService;
import com.epita.fr.quizAJ.datamodels.ChoiceModel;
import com.epita.fr.quizAJ.datamodels.*;



@Path("/authenticate")
public class AuthenticationResource {
	
	@Inject
	ProfessorDAO professorDAO;
	
	@Inject
	StudentDAO studentDAO;

	

	
	@POST
	@Path("/professor")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response authenticateProfessor(ProfessorModel professorModel) throws URISyntaxException {
		
		
		/*
		 *  {
        		"profName": "Thomas",
        		"profPassword": "******"
 			}
 			
		 * */
		
		if(professorDAO.authenticate(professorModel))
		{
			return Response.ok("Sorry, you are not the account holder of : "+professorModel.getProfName()).build();	
		}
		else
		{
			return Response.ok("Welcome  : "+professorModel.getProfName()).build();
		}
	}

	@POST
	@Path("/student")
	@Consumes(value = { MediaType.APPLICATION_JSON })
	public Response authenticateStudent(StudentModel studentModel) throws URISyntaxException {
		
		
		/*
		 *  {
        		"studentName": "Rajan",
        		"studentPassword": "******"
 			}
 			
		 * */

		
		if(studentDAO.authenticate(studentModel))
		{
			return Response.ok("Sorry, you are not the account holder of : "+studentModel.getStudentName()).build();	
		}
		else
		{
			return Response.ok("Welcome  : "+studentModel.getStudentName()).build();
		}
			
	}
}
