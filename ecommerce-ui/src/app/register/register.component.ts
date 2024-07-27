import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterModule,RegisterComponent,FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user = { username: '', password: '' };

  constructor(private authService: AuthService) { }

  onRegister() {
    this.authService.register(this.user).subscribe((response: any) => {
      alert(JSON.stringify(response));
    });
 }
}
