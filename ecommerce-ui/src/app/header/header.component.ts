import { Component, OnInit } from '@angular/core';
import { User } from '../app.models';
import { CartComponent } from '../cart/cart.component';
import { Router, RouterModule } from '@angular/router';
import { NgIf } from '@angular/common';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';
import { ProductsService } from '../services/products.service';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CartComponent,RouterModule,FormsModule,NgIf],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit{

  user?:User;

  key:string = "";

  cartCount:number = 0;

  constructor(
    private auth:AuthService,
    private router:Router,
    private productsService:ProductsService,
    private cartService: CartService

  ){
    this.auth.user.subscribe(u=>this.user=u);
    this.cartService.refresh.subscribe(c=>this.cartCount=c);
  }
  ngOnInit(): void {
    this.auth.user.subscribe(u=>this.user=u);
  }


  logout(){
    this.auth.logout();
    this.router.navigate(["login"]);
  }

  search(){
    this.productsService.search(this.key);
  }

}
