import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { User } from '../../app.models';
import { FormsModule } from '@angular/forms';
import { AdminService } from '../admin.service';
import { ToastService } from '../../toast/toast.service';

@Component({
  selector: 'app-users',
  standalone: true,
  imports: [NgFor,FormsModule],
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {

  users: User[] = [];
  roles: string[] = ['ADMIN', 'USER'];

  ngOnInit(): void {
    this.generateUsers();
  }

  constructor(private adminService:AdminService,private toastService:ToastService){

  }

  generateUsers() {
    this.adminService.getUsers().subscribe(response=>{
      this.toastService.showSuccess("Success","Users fetched successfully");
      console.log(response);
      this.users = response.data;
    },error=>{
      this.toastService.showError("Failed","Unable to retrieve users");
    })
  }

  changeUserRole(user: User, role: string): void {
    user.role = role;
  }

}
