import { Injectable } from '@angular/core';

import { Product } from '../app.models';
import { BehaviorSubject, Observable, Subject, of, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  refresh:Subject<boolean> = new BehaviorSubject(false);

  products:Product[] = [];

  constructor(private http:HttpClient) {
    this.http.get("api/products").subscribe((res:any)=>{
      this.products = res;
      this.refresh.next(true);
    });
  }

  getProductById(productId: number): Observable<Product> {
    for(var i in this.products){
      if(this.products[i].id==productId){
        return of(this.products[i]);
      }
    }
    return throwError("no product");
  }
}
