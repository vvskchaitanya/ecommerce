import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Product } from '../app.models';
import {  ProductsService } from  '../services/products.service';
import { EMPTY, catchError } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { CurrencyPipe, NgIf } from '@angular/common';
import { LoaderService } from '../loader/loader.service';
import { CartService } from '../services/cart.service';
import { ToastService } from '../toast/toast.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [RouterModule,FormsModule,NgIf,CurrencyPipe],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

  product?:Product;
  selectedQuantity:number = 1;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductsService,
    private loaderService: LoaderService,
    private cartService: CartService,
    private toastService: ToastService,
    private authService: AuthService,
    private router:Router
  ) {}

  ngOnInit() {
    this.loaderService.show();
    const productId = this.route.snapshot.params['id'];
    this.productService.getProductById(productId)
      .pipe(
        catchError(err => {
          this.loaderService.hide();
          console.error('Error fetching product details:', err);
          return EMPTY;
        })
      )
      .subscribe(
        (product: Product) => {
          this.loaderService.hide();
          this.product = product;
        }
      );
  }

  addToCart() {
    if(this.product){
      let user = sessionStorage.getItem("user");
      if(user==null){
        this.router.navigateByUrl("login");
      }else{
        this.cartService.addtoCart(this.product,this.selectedQuantity);
        this.toastService.showSuccess("Success","Product added to cart");

      }
    }   
  }
}
