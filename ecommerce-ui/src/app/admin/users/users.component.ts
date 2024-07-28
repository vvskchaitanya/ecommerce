import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { User } from '../../app.models';
import { FormsModule } from '@angular/forms';

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
    this.users = this.generateUsers();
  }

  generateUsers(): User[] {
    // Mock user data
    return [
      { id: "1", name: 'Alice', role: 'USER',email:"" },
      { id: "2", name: 'Bob', role: 'ADMIN',email:"" },
      { id: "3", name: 'Charlie', role: 'USER',email:"" },
      { id: "4", name: 'David', role: 'ADMIN',email:"" },
      { id: "5", name: 'Eve', role: 'USER',email:"" }
    ];
  }

  changeUserRole(user: User, role: string): void {
    user.role = role;
  }

}
