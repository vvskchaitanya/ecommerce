import { Injectable } from '@angular/core';
import { BehaviorSubject, ReplaySubject, Subject } from 'rxjs';
import { User } from '../app.models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user:Subject<User | undefined> =  new Subject<User | undefined>();

  constructor() { }

  login(){
    this.user.next({id:"test",name:"Chaitanya",email:"test@test.com",role:"USER"});
  }

  logout(){
    this.user.next(undefined);
  }
}
