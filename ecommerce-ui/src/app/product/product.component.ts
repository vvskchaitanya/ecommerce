import { Component } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Product } from '../app.models';
import {  ProductsService } from  '../services/products.service';
import { EMPTY, catchError } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [RouterModule,FormsModule,NgIf],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

  product?:Product;
  selectedQuantity:number = 1;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductsService,
  ) {}

  ngOnInit() {
    const productId = this.route.snapshot.params['id'];
    this.productService.getProductById(productId)
      .pipe(
        catchError(err => {
          console.error('Error fetching product details:', err);
          return EMPTY;
        })
      )
      .subscribe(
        (product: Product) => {
          this.product = product;
        }
      );
  }

  addToCart() {
  }

}
