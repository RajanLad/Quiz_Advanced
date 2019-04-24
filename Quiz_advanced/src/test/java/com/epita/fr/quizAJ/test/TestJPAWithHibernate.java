package com.epita.fr.quizAJ.test;

import java.sql.Connection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epita.fr.quizAJ.DAO.QuestionsDAO;
import com.epita.fr.quizAJ.datamodels.QuestionModel;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/test_applicationContext.xml"})
public class TestJPAWithHibernate {

	
	@Inject
	@Named("sessionFactory")
	SessionFactory sessionFactory;
	
	@Inject
	QuestionsDAO dao;
	

	@Test
	public void testHibernateSessionFactory() throws Exception {

		Assert.assertNotNull(sessionFactory);
		
		//given
		Session session = sessionFactory.openSession();
		QuestionModel question = new QuestionModel();
		String expected = "What is Hibernate?";
		question.setContent(expected);
		
		//when
		session.save(question);
		
		
		//then
		QuestionModel retrievedQuestion = session.get(QuestionModel.class, question.getId());
		Assert.assertEquals(expected, retrievedQuestion.getContent());
		
		session.close();
		
	}
	
	@Test
	public void testQuestionDAO() throws Exception {
		QuestionModel question = new QuestionModel();
		String expected = "What is Hibernate?";
		question.setContent(expected);
		dao.create(question);
		
		List<QuestionModel> searchResult = dao.search(question);
		Assert.assertNotEquals(0, searchResult.size());
		
	}
	

}
