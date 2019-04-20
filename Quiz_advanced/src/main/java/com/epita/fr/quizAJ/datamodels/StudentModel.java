package com.epita.fr.quizAJ.datamodels;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int studentId;

	@Column(name = "StudentName")
	String studentName;

	@Column(name = "StudentPassword")
	String studentPassword;
	
	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Column(name = "StudentScore")
	String studentScore;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(String studentScore) {
		this.studentScore = studentScore;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	

}