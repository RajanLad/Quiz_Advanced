import { Injectable } from '@angular/core';
import { Question } from '../datamodel/question';
import { Choice } from 'src/app/datamodel/choice';
  
  


@Injectable({
  providedIn: 'root'
})
export class QuestionService {
 

  questionList : Question[] = [
    new Question('What is Java')];

  choiceList : Choice[] = [
    new Choice('A Object oriented Language'),
    new Choice('A Procedure oriented language'),
    new Choice('None of above')];

  constructor() { }

  getQuestions() : Question[]{
    return this.questionList;
  } 

  getChoices() : Choice[]{
    return this.choiceList;
  } 

  save(question: Question): void {
    this.questionList.push(question);
  }

  saveChoice(choice: Choice): void {
    this.choiceList.push(choice);
  }
}
