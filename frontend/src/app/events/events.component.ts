import {Events } from './events';
import {eventsService } from './events.service';

import { Component , OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css'],
})

export class EventsComponent implements OnInit {
  errorMessage : string;
  events : Events[];
  regid : String;

  constructor(private eventsService : eventsService,
              private route : Router){}
 
  ngOnInit(){
    this.getAll();
  };
  getAll(): void {
    this.eventsService
        .getAll()
        .subscribe(events => this.events = <Events[]>events,
                     error =>  this.errorMessage = <any>error);
  }
  Reg(eid:number,id:number,tikcnt:number){
    console.log(eid + "eid");
    console.log(id + "id");
    console.log(tikcnt + "tk");
    this.eventsService.reg(eid,id,tikcnt);
    this.regid = localStorage.getItem("regid");
    
  }


}
