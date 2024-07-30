import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [NgIf,NgFor],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {
  cartItems: CartItem[] = [];
  totalPrice: number = 0;

  constructor(private cartService:CartService){

  }

  ngOnInit(): void {
    this.loadCartItems();
    this.calculateTotalPrice();
  }

  loadCartItems() {
    this.cartItems = [];
    this.cartService.cart.forEach((c:any)=>{
      this.cartItems.push({id:c.product.id,name:c.product.name,price:c.product.price,quantity:c.quantity});
    })

  }

  calculateTotalPrice(): void {
    this.totalPrice = this.cartItems.reduce((total, item) => {
      return total + item.price*item.quantity
    },0);
  }

  // Method to clear the cart
  clearCart(): void {
    this.cartItems = [];
    this.calculateTotalPrice();
    sessionStorage.removeItem("cart");
  }

  // Method to remove an item from the cart
  removeItem(itemId: string): void {
    this.cartItems = this.cartItems.filter(item => item.id !== itemId);
    this.calculateTotalPrice();
  }

}

interface CartItem {
  id: string;
  name: string;
  price: number;
  quantity: number;
}

