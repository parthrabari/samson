import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from '../login/login.component';
import { LandingComponent } from '../landing/landing.component';
import { EventsComponent } from '../events/events.component';
import {eventsService} from '../events/events.service';

import { CommonModule } from '@angular/common';
import { AppRoutingModule }     from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LandingComponent,
    EventsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    CommonModule
  ],
  providers: [eventsService],

  bootstrap: [AppComponent]
})
export class AppModule { }
