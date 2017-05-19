import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {AppComponent } from './app.component';
import {LoginComponent } from '../login/login.component';
import {LandingComponent} from '../landing/landing.component';
import { EventsComponent } from '../events/events.component';

const routes : Routes = [
    {path:'', redirectTo: '/landing', pathMatch: 'full'},
    {path:'landing',component:LandingComponent},        
    {path:'login',component:LoginComponent},
    {path:'events',component:EventsComponent},    
];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})

export class AppRoutingModule{}


