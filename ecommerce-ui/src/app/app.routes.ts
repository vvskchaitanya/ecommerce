import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './products/products.component';
import { ProductComponent } from './product/product.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CartComponent } from './cart/cart.component';
import { ProfileComponent } from './profile/profile.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { authGuard } from './services/auth.guard';
import { UnauthorizedComponent } from './unauthorized/unauthorized.component';
import { PaymentComponent } from './payment/payment.component';

export const routes: Routes = [
    {path:"", redirectTo:"home",pathMatch:"full"},
    {path:"home", component:HomeComponent},
    {path:"products", component:ProductsComponent},
    {path:"product/:id", component:ProductComponent},
    {path:"login", component:LoginComponent},
    {path:"register", component:RegisterComponent},
    {path:"cart", component: CartComponent},
    {path:"profile", component: ProfileComponent},
    {path:"unauthorized",component:UnauthorizedComponent},
    {path:"payment",component:PaymentComponent},
    {path:"admin",component:DashboardComponent, canActivate:[authGuard]},
    {path:"admin/:view",component:DashboardComponent, canActivate:[authGuard]}
];
