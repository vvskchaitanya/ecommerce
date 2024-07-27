import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule,LoginComponent,FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  user = { username: '', password: '' };

  constructor(private authService: AuthService) { }

  onLogin() {
    this.authService.login(this.user).subscribe((response: any) => {
      alert(JSON.stringify(response));
    });
  }

}