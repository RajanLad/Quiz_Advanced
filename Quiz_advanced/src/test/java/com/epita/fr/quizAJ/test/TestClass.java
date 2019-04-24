package com.epita.fr.quizAJ.test;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epita.fr.quizAJ.DAO.ChoicesDAO;
import com.epita.fr.quizAJ.Services.QuizDataService;
import com.epita.fr.quizAJ.datamodels.ChoiceModel;
import com.epita.fr.quizAJ.datamodels.QuestionModel;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/test_applicationContext.xml"})

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:test-app-context.xml")

public class TestClass {

	@Inject
	QuizDataService quizDS;

	@Inject
	ChoicesDAO choicesDAO;
	
	
	@Test
	public void testQuestionWithChoicesInsertion() {
		
		//given
		QuestionModel question = new QuestionModel();
		question.setContent("What is maven ?");
		ChoiceModel choice1 = new ChoiceModel();
		String firstChoiceText = "it is a dependency injection framework";
		choice1.setChoice_opt(firstChoiceText);
		choice1.setValid(false);
		ChoiceModel choice2 = new ChoiceModel();
		choice2.setChoice_opt("it is including a dependency management tool");
		choice2.setValid(true);
		
		//when
		quizDS.createQuestionAndChoices(question, choice1, choice2);
		
		//then
//		ChoiceModel criteria = new ChoiceModel();
//		criteria.setQuestionReference(question);
//		List<ChoiceModel> searchResults = choicesDAO.search(criteria);
//		Assert.assertTrue(!searchResults.isEmpty());
		
		
		//Other way to use stream without lambdas
//		searchResults.stream().filter(new Predicate<Choice>() {
//
//			@Override
//			public boolean test(Choice t) {
//				return t.getQuestion().equals(firstChoiceText);
//			}
//		});
		
//		List<Choice> subList = searchResults.stream()
//				.filter(c -> c.getText().equals(firstChoiceText))
//				.collect(Collectors.toList());
//		
//		Assert.assertEquals(1, subList.size());
		
	}
	
}
