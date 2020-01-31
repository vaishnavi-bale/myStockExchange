import { Component, OnInit } from '@angular/core';
import { HomeService } from '../home.service';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users:User[];
  constructor(private homeService: HomeService,private router: Router) { }
  
  ngOnInit() {
    
    this.homeService.getAllUsers().subscribe(data => {
      this.users=data;
    })
  }
  deleteUser(user: User){
    this.homeService.deleteUser(user.id).subscribe();
    this.users=this.users.filter(u => u !== user );
  }
  updateUser(user: User){
    localStorage.removeItem('userId');
    localStorage.setItem('userId',user.id.toString());
    this.router.navigate(['update'])
  }
  }
