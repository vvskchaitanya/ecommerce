import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Product } from '../app.models';
import { ProductsService } from '../services/products.service';
import { CurrencyPipe, NgFor } from '@angular/common';
import { ProductFilterComponent } from '../product-filter/product-filter.component';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [RouterModule, NgFor, CurrencyPipe, ProductFilterComponent],
  providers: [],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {

  products: Product[] = [];

  constructor(private productService: ProductsService) { }

  ngOnInit() {
    this.productService.refresh.subscribe(()=>{
      this.products = this.productService.products;
    })
  }

  sort(){
    this.productService.sort();
  }

}
