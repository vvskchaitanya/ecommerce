import { Injectable } from '@angular/core';

import { Product } from '../app.models';
import { Observable, of, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  products:Product[] = [];

  constructor() { }

  getProductById(productId: number): Observable<Product> {
    for(var i in this.products){
      if(this.products[i].id==productId){
        return of(this.products[i]);
      }
    }
    return throwError("no product");
  }
}
