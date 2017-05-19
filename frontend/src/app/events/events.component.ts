import {Events } from './events';
import {eventsService } from './events.service';
import {Registration} from './RegSuccess';

import { Component , OnInit } from '@angular/core';
import { Router }            from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css'],
})

export class EventsComponent implements OnInit {
  title = 'events works!';
  errorMessage : string;
  events : Events[];
  regid : number;

  constructor(private eventsService : eventsService,
              private route : Router){}
 
  ngOnInit(){
    this.getAll();
    this.title = 'Rom';
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
    let reg = this.eventsService.reg(eid,id,tikcnt);
    
  }


}
