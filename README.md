# Advanced Java project : Quiz Manager II 

This is Quiz Manager that is implemented based on previous Java Project, but by using various components of J2EE (Spring,Hibernate,JUnit) both Java Specification (javax.*) , Vendor specific specification (Spring,Hibernate) and H2 for database. 

For this project both Java Project(DAO,Datamodel,Services,DataHolders) and Java Web Project (REST) is implemented using Maven.
And for front-end I have implemented it in Angular JS.

There are four projects in the git : 

 > - **epita-parent** : central repo for the different J2EE projects, but for this case, it is just used for **Quiz_advanced** project.
 > - **Quiz_advanced** : J2EE project implementing (DAO,Datamodel,Services,DataHolders) using Dependency Injection using Spring, persistance using Hibernate. 
  > - **quiz-rest-service** : Java web project , using REST service architecture. Rest service is implemented using Jersey by Glassfish, javax specfication,etc.
  > - **quiz-frontend** : In order to communicate with the rest service , a front end is implemented using Angular JS.
  


## Quiz_advanced

  In this project I have implemented **CRUD** and **authentication** for Professor and Student to allow or restrict certain aspects of CRUD of Questions and Choices for a particular question.
  
  - **DAOs**
    - CommonDAO
    - QuestionDAO
    - ChoiceDAO
    - ProfessorDAO
    - StudentDAO
    
  - **Datamodels**
    - ChoiceModel
    - QuestionModel
    - ProfessorModel
    - StudentModel
    
  - **Services**
    - QuizDataService
    
  - **Holders**
    - GenericQueryHolder
    
  - **Resources**
    - applicationContext.xml
    - pom.xml(Maven dependencies)
    - log4j.xml
    
> ###### Dependencies
> - com.h2database
> - org.springframework
> - junit
> - org.hibernate
> - org.apache.logging.log4j
> - javax.inject

## quiz-rest-service

  In this project I have implemented REST specification for **CRUD** and **authentication** activities implemented in earlier project.
  
  - **Web Controller resources (Java Resources with @Path implementation)**
    - AuthenticationResource
    - QuestionResource
    - ChoiceResource
    - StartQuizResource
    
  - **Web Resources**
    - applicationContext.xml
    - web.xml
    
  - **Resources**
    - pom.xml
    
  - **Servers**
    - Tomcat Server 9.0.0
    
> ###### Dependencies
> - org.springframework
> - org.glassfish.jersey.core
> - org.glassfish.jersey.media
> - org.glassfish.jersey.ext
> - com.epita.fr.myproject_quiz(J2EE project with datamodel and DAO's for this project)
> - javax.inject

## quiz-frontend

  I have implemented this project using AngularJS to communicate with URLs in REST Services
  
  - **Components**
    - question-form (Both Questions and corresponding choices)
    - question-list (Both Questions and corresponding choices)
    
  - **DataModels**
    - choice.ts
    - question.ts
    
  - **Service**
    - question.service.ts
    
  - **module**
    - app.module.ts
    
> ###### app.module.ts (Different Modules) :
> - BrowserModule 
> - NgModule 
> - FormsModule 
> - HttpClientModule 
> - HttpModule 
> - Http 
> - AppRoutingModule 
> - AppComponent 
> - QuestionFormComponent 
> - QuestionListComponent 
