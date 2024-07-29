import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../app.models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  user:BehaviorSubject<User | undefined> =  new BehaviorSubject<User | undefined>(undefined);
  
  private apiUrl = '/api';

  constructor(private http: HttpClient) { 
   let usersession = sessionStorage.getItem("user");
    if(usersession!=null){
      let user:User = JSON.parse(usersession);
      this.user.next(user);
      console.log("Refreshing User Session",user);
    } 
  }

  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/register`, user);
  }

  login(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/authentication/login`, user);
  }

  logout() {
    sessionStorage.clear();
    this.user.next(undefined);
    
  }

  createSession(user:User,token:string){
    sessionStorage.setItem("user",JSON.stringify(user));
    sessionStorage.setItem("token",token);
    this.user.next(user);
  }
}
