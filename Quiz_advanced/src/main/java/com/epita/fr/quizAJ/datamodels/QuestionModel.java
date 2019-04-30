package com.epita.fr.quizAJ.datamodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS")
public class QuestionModel {

	public QuestionModel() {

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Q_ID")
	private Integer q_id; 
	
	@Column(name="Q_CONTENT")
	private String q_content; 
	
	public Integer getId() {
		return q_id;
	}

	public void setId(Integer id) {
		this.q_id = id;
	}

	public String getContent() {
		return q_content;
	}

	public void setContent(String content) {
		this.q_content = content;
	}
	
}
