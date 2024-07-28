import { Component } from '@angular/core';
import { Product } from '../../app.models';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [NgFor],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {

  products: Product[] = [];
  paginatedProducts: Product[] = [];
  currentPage: number = 1;
  pageSize: number = 10; // Number of items per page

  ngOnInit(): void {
    // Initialize with mock data
    this.products = this.generateProducts();
    this.paginate();
  }

  generateProducts(): Product[] {
    // Create mock products
    return Array.from({ length: 50 }, (_, i) => ({
      id: i + 1,
      name: `Product ${i + 1}`,
      price: Math.random() * 100,
      stock: Math.floor(Math.random() * 100),
      description:"",
      image:""
    }));
  }

  paginate(): void {
    const start = (this.currentPage - 1) * this.pageSize;
    const end = start + this.pageSize;
    this.paginatedProducts = this.products.slice(start, end);
  }

  changePage(page: number): void {
    this.currentPage = page;
    this.paginate();
  }

  get totalPages(): number {
    return Math.ceil(this.products.length / this.pageSize);
  }

  get pages(): number[] {
    return Array.from({ length: this.totalPages }, (_, i) => i + 1);
  }


}
