import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../app.models';
import { AppModule } from '../app.module';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [AppModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.less'
})
export class ProductsComponent {

  products:Product[] = [];

  selectedBrand?:string;

  constructor(private http: HttpClient){
    this.http.get("assets/products.json").subscribe((res:any)=>{
      this.products = res;
    })
  }

  addToCart(p:Product){

  }

  addFavourite(p:Product){

  }
}
