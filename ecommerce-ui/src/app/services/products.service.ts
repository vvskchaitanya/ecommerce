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

  sorted:boolean =false;

  constructor(private http:HttpClient) {
    this.http.get("api/products").subscribe((res:any)=>{
      this.products = res;
      this.refresh.next(true);
    });
  }

  getProductById(productId: string): Observable<Product> {
    for(var i in this.products){
      if(this.products[i].id==productId){
        return of(this.products[i]);
      }
    }
    return throwError("no product");
  }

  search(name:string){
    this.http.get("api/products/search?name="+name).subscribe((res:any)=>{
      this.products = res;
      this.refresh.next(true);
    });
  }

  sort(){
    this.sorted?this.products.sort((a,b)=> b.price-a.price):this.products.sort((a,b)=> a.price-b.price);
    this.refresh.next(true);
    this.sorted=!this.sorted;
  }
}
