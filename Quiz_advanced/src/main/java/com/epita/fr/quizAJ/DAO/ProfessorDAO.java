package com.epita.fr.quizAJ.DAO;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.epita.fr.quizAJ.Holders.GenericQueryHolder;
import com.epita.fr.quizAJ.datamodels.ProfessorModel;

@Repository
public class ProfessorDAO extends CommonDAO<ProfessorModel>
{

	@Override
	public void prepareSearch(ProfessorModel criteria, GenericQueryHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void authenticateUser(ProfessorModel prof, GenericQueryHolder holder) {
		// TODO Auto-generated method stub
		
		holder.setQueryString("from Professor where U_ID=:username and U_PWD=:password"); 
		holder.setClassName(ProfessorModel.class);
		holder.putParameter("username", prof.getProfName());
		holder.putParameter("password", prof.getProfPassword());
		
	}

}
