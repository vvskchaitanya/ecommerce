import { Component } from '@angular/core';
import { Product } from '../../app.models';
import { NgFor } from '@angular/common';
import { AdminService } from '../admin.service';
import { ToastService } from '../../toast/toast.service';

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

  constructor(private adminService:AdminService,private toastService:ToastService){
    
  }

  ngOnInit(): void {
    this.generateProducts();
    this.paginate();
  }

  generateProducts(){
    this.adminService.getProducts().subscribe(response=>{
      this.toastService.showSuccess("Success","Products fetched successfully");
      console.log(response);
      this.products = response;
      this.paginate();
    },error=>{
      this.toastService.showError("Failed","Unable to retrieve products");
    })
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
