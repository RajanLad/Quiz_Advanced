package com.epita.fr.quizAJ.datamodels;

import javax.persistence.*;

@Entity
@Table(name="ADMIN")

public class ProfessorModel {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int id;
		
		@Column(name="ProfName")
		String profName;

		@Column(name="ProfPassword")
		String profPassword;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProfName() {
			return profName;
		}

		public void setProfName(String profName) {
			this.profName = profName;
		}

		public String getProfPassword() {
			return profPassword;
		}

		public void setProfPassword(String profPassword) {
			this.profPassword = profPassword;
		}
}
