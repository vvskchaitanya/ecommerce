import { Component } from '@angular/core';
import { Product } from '../app.models';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.less'
})
export class CartComponent {

  cart:Product[] = [];

  constructor(){
    let a = sessionStorage.getItem("cart");
    this.cart = a?JSON.parse(a):[];
  }
}
