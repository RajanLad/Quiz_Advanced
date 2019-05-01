import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { HttpModule } from '@angular/http';
import { Http } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import { QuestionListComponent } from './components/question-list/question-list.component';

// <sourceDirectory>src</sourceDirectory>

@NgModule({
  declarations: [
    AppComponent,
    QuestionFormComponent,
    QuestionListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
