import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [NgFor,FormsModule],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent {

  orders: Order[] = [];
  statuses: string[] = ['PENDING', 'PROCESSING', 'SHIPPED', 'DELIVERED', 'CANCELLED'];

  ngOnInit(): void {
    this.orders = this.generateOrders();
  }

  generateOrders(): Order[] {
    // Mock orders data
    return [
      { orderId: 101, userId: 1, productId: 1001, productName: 'Laptop', status: 'PENDING' },
      { orderId: 102, userId: 2, productId: 1002, productName: 'Smartphone', status: 'PROCESSING' },
      { orderId: 103, userId: 1, productId: 1003, productName: 'Tablet', status: 'SHIPPED' },
      { orderId: 104, userId: 3, productId: 1004, productName: 'Headphones', status: 'DELIVERED' },
      { orderId: 105, userId: 4, productId: 1005, productName: 'Camera', status: 'CANCELLED' }
    ];
  }

  changeOrderStatus(order: Order, status: string): void {
    order.status = status;
  }

}

interface Order {
  orderId: number;
  userId: number;
  productId: number;
  productName: string;
  status: string;
}
