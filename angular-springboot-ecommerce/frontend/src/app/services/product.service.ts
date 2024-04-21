import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';

export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  imgUrl: string;
  image:string;
}

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products:Product[] = [];
  private apiUrl = 'https://8080-vvskchaitanya-ecommerce-roqfltrnlgh.ws-us110.gitpod.io//api/v1/products';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/all`);
  }

  getProductById(productId: number): Observable<Product> {
    for(var i in this.products){
      if(this.products[i].id==productId){
        return of(this.products[i]);
      }
    }
    return throwError("no product");
  }

  addToCart(productId: number, quantity: number): Observable<any> {
    const userId = localStorage.getItem('user_id');

    const headers = new HttpHeaders({
      Authorization: 'Bearer ' + localStorage.getItem('access_token')
    });

    return this.http.post<number>(`http://localhost:8080/api/v1/cart/${userId}/${productId}/${quantity}`, {}, { headers });
  }
}
