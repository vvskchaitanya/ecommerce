import { Injectable } from '@angular/core';
import { Product } from '../app.models';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: any[] = [];

  constructor() { 
    let cartObj = sessionStorage.getItem("cart");
    if(cartObj!=null){
      this.cart = JSON.parse(cartObj);
    }
  }

  addtoCart(product:Product, quantity:number){
    this.cart.push({product:product,quantity:quantity});
    sessionStorage.setItem("cart",JSON.stringify(this.cart));
  }

  removeFromCart(){
    // TBD
  }
}
