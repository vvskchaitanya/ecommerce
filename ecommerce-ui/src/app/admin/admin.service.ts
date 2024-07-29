import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private apiUrl = '/api';

  constructor(private http: HttpClient) { 
   
  }

  getUsers(): Observable<any> {
    let token = sessionStorage.getItem("token");
    return this.http.get(`${this.apiUrl}/users/`,{headers:{"Authorization":"Bearer "+token}});
  }

  getProducts(): Observable<any> {
    let token = sessionStorage.getItem("token");
    return this.http.get(`${this.apiUrl}/products`,{headers:{"Authorization":"Bearer "+token}});
  }
}
