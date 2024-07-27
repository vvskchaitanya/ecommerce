import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../app.models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  user:Subject<User | undefined> =  new Subject<User | undefined>();
  
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

  createSession(user:User){
    sessionStorage.setItem("user",JSON.stringify(user));
    this.user.next(user);
  }
}
