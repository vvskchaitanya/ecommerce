import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { ProductComponent } from './product/product.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CartComponent } from './cart/cart.component';
import { ProfileComponent } from './profile/profile.component';

export const routes: Routes = [
    {path:"", redirectTo:"home",pathMatch:"full"},
    {path:"home", component:HomeComponent},
    {path:"products", component:ProductsComponent},
    {path:"product/:id", component:ProductComponent},
    {path:"login", component:LoginComponent},
    {path:"register", component:RegisterComponent},
    {path:"cart", component: CartComponent},
    {path:"profile", component: ProfileComponent}
];
