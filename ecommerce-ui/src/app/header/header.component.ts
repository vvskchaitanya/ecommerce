import { Component } from '@angular/core';
import { User } from '../app.models';
import { CartComponent } from '../cart/cart.component';
import { Router, RouterModule } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CartComponent,RouterModule,NgIf],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  user?:User;

  constructor(private router:Router){

  }

  logout(){

  }

}
