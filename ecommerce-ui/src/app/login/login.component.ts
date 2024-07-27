import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormsModule, NgModel } from '@angular/forms';
import { JsonPipe } from '@angular/common';
import { User } from '../app.models';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule,LoginComponent,FormsModule,JsonPipe],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public user:any = { username: "", password: "" };

  constructor(private authService: AuthService, private router:Router) { }

  async onLogin() {
    console.log("Logging in for "+this.user.username);
    this.authService.login(this.user).subscribe((response: any) => {
      if(response.success){
        let token = response.data;
        let tokenpayload = token.split(".")[1];
        var tokenparse:any = atob(tokenpayload);
        tokenparse = JSON.parse(tokenparse);
        let loginuser: User = {id:tokenparse.id,name:tokenparse.username,role:tokenparse.role,email:tokenparse.id};
        console.log(loginuser);
        this.authService.createSession(loginuser);
        this.router.navigate(["home"]);
      }else{
        alert(response.code);
      }
    });
  }

}