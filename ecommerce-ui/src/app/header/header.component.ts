import { Component, OnInit } from '@angular/core';
import { User } from '../app.models';
import { CartComponent } from '../cart/cart.component';
import { Router, RouterModule } from '@angular/router';
import { NgIf } from '@angular/common';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';
import { ProductsService } from '../services/products.service';

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

  constructor(
    private auth:AuthService,
    private router:Router,
    private productsService:ProductsService

  ){
    this.auth.user.subscribe(u=>this.user=u);
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
