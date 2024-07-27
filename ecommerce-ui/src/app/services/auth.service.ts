import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  
  private apiUrl = '/api';
  user: any;
  auth: any;

  constructor(private http: HttpClient) { }

  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/register`, user);
  }

  login(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/authentication/login`, user);
  }

  logout() {
    this.auth.logout();
  }
}
