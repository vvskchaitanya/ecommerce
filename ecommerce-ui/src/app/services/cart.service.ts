import { Injectable } from '@angular/core';
import { Product } from '../app.models';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: any[] = [];

  refresh:BehaviorSubject<number>= new BehaviorSubject(0);

  constructor() { 
    let cartObj = sessionStorage.getItem("cart");
    if(cartObj!=null){
      this.cart = JSON.parse(cartObj);
      this.refresh.next(this.cart.length);
    }
  }

  addtoCart(product:Product, quantity:number){
    this.cart.push({product:product,quantity:quantity});
    sessionStorage.setItem("cart",JSON.stringify(this.cart));
    this.refresh.next(this.cart.length);
  }

  removeFromCart(){
    this.cart=[];
    sessionStorage.removeItem("cart");
    this.refresh.next(0);
  }
}
