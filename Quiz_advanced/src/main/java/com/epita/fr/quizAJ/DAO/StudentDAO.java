package com.epita.fr.quizAJ.DAO;

import org.springframework.stereotype.Repository;

import com.epita.fr.quizAJ.Holders.GenericQueryHolder;
import com.epita.fr.quizAJ.datamodels.ProfessorModel;
import com.epita.fr.quizAJ.datamodels.StudentModel;

@Repository
public class StudentDAO extends CommonDAO<StudentModel>
{

	@Override
	public void prepareSearch(StudentModel criteria, GenericQueryHolder<StudentModel> holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void authenticateUser(StudentModel stud, GenericQueryHolder<StudentModel> holder) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		holder.setQueryString("from Student where U_ID=:username and U_PWD=:password"); 
		holder.setClassName(StudentModel.class);
		holder.putParameter("username", stud.getStudentName());
		holder.putParameter("password", stud.getStudentPassword());
	}
	
}
