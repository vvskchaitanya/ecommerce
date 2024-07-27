import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormsModule, NgModel } from '@angular/forms';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule,LoginComponent,FormsModule,JsonPipe],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public user:any = { username: "", password: "" };

  constructor(private authService: AuthService) { }

  onLogin() {
    console.log("Logging in for "+this.user.username);
    this.authService.login(this.user).subscribe((response: any) => {
      alert(JSON.stringify(response));
    });
  }

}