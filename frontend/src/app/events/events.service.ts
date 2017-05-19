import { Injectable } from '@angular/core';
import { Http,Headers,Response,RequestOptions }    from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

import {Events } from './events';
import {Registration} from './RegSuccess';

@Injectable()
export class eventsService{
    private url = 'http://localhost:8080/api/events';
    registered : Registration;
    constructor(private http : Http ) {}

    reg(eid : number,id :number,tikcnt : number) { 
     let regurl = 'http://localhost:8080/api/register/';
    console.log("serv"); 
    console.log(eid + "eid");
    console.log(id + "id");
    console.log(tikcnt + "tk");
     let body = JSON.stringify({
      "eid":eid,
      "id":id,
      "tikcnt" : tikcnt 
     });
    console.log(body);

     let headers = new Headers({'Content-Type': 'application/json'});
     let options = new RequestOptions({headers: headers});

     return this.http.post(regurl,body,options)
               .flatMap((res : Response) => {
                 var location= res.headers.get('location');
                 console.log(location);
                 return this.http.get(location);})
                 .map((res:Response)=> {
                   console.log(res.json());
                   res.json()})   
                 .subscribe()                
                 ;
                  
    }

    getAll() : Observable<Events[]> {

        return this.http.get(this.url)
                   .map(this.extractData)
                    .catch(this.handleError);
        
    }
    private extractData(res: Response) {
    let body = <Events[]>res.json();
    console.log(body);
    return body;
  }

    private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}