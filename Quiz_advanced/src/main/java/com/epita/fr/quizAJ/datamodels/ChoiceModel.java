package com.epita.fr.quizAJ.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Choice")
public class ChoiceModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="C_Id")
	int c_id;
	
	@ManyToOne
	QuestionModel questionReference; 
	
	@Column(name="Choice")
	String choice_opt;
	
	@Column(name="Choice_Number")
	String choice_Number;
	
	@Column
	Boolean valid;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public QuestionModel getQuestionReference() {
		return questionReference;
	}

	public void setQuestionReference(QuestionModel questionReference) {
		this.questionReference = questionReference;
	}

	public String getChoice_opt() {
		return choice_opt;
	}

	public void setChoice_opt(String choice_opt) {
		this.choice_opt = choice_opt;
	}

	public String getChoice_Number() {
		return choice_Number;
	}

	public void setChoice_Number(String choice_Number) {
		this.choice_Number = choice_Number;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	
}
