import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question';
import { Choice } from 'src/app/datamodel/choice';
import { QuestionService } from 'src/app/services/question.service';

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  question : Question = new Question('');
  choice : Choice = new Choice('');


  constructor(private questionService : QuestionService) { }

  ngOnInit() {
  }

  save() : void
  {
    this.questionService.save(this.question);
    this.question = new Question('');
  }

  saveChoice() : void
  {
    this.questionService.saveChoice(this.choice);
    this.choice = new Choice('');
  }
}
