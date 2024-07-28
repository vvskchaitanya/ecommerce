import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router, RouterLink, RouterLinkActive } from '@angular/router';
import { UsersComponent } from '../users/users.component';
import { ProductsComponent } from '../products/products.component';
import { OrdersComponent } from '../orders/orders.component';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [RouterLink,RouterLinkActive,NgIf,UsersComponent,ProductsComponent,OrdersComponent],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  view:string = "";

  constructor(private router:Router,public route:ActivatedRoute){
    router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
          this.view = this.route.snapshot.paramMap.get('view') || "";
      }
    });
  }

}
