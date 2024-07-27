import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { ToastService } from '../toast/toast.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterModule,RegisterComponent,FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user = { username: '', password: '' };

  constructor(
    private authService: AuthService,
    private toastService: ToastService
  ) { }

  onRegister() {
    this.authService.register(this.user).subscribe((response: any) => {
      if(response.success){
        // Show Success Toast Message
        this.toastService.showSuccess("Registration Success","User: "+this.user.username+", Please proceed to login");
        // Reset User fields
        this.user = { username:"",password:""};
      }else{
        // Show Failed Toast Message
        this.toastService.showError("Registration Failed", "User: "+this.user.username+". Please reach out to ecom@support.com")
      }
    });
 }
}
