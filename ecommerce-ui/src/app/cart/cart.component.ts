import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';

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

  ngOnInit(): void {
    this.cartItems = this.loadCartItems();
    this.calculateTotalPrice();
  }

  loadCartItems(): CartItem[] {
    // Mock data for cart items
    return [
      { id: 1, name: 'Laptop', price: 999.99, quantity: 1 },
      { id: 2, name: 'Smartphone', price: 499.99, quantity: 2 },
      { id: 3, name: 'Headphones', price: 99.99, quantity: 1 }
    ];
  }

  calculateTotalPrice(): void {
    this.totalPrice = this.cartItems.reduce((total, item) => total + item.price * item.quantity, 0);
  }

  // Method to clear the cart
  clearCart(): void {
    this.cartItems = [];
    this.calculateTotalPrice();
  }

  // Method to remove an item from the cart
  removeItem(itemId: number): void {
    this.cartItems = this.cartItems.filter(item => item.id !== itemId);
    this.calculateTotalPrice();
  }

}

interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

