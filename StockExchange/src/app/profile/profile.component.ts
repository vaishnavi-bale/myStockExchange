import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { HomeService } from '../home.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
user:User;
  constructor(private homeService:HomeService,private router:Router) { }

  ngOnInit() {
    const c = sessionStorage.getItem('username');
    console.log(c)
    if (+ c !=null) {
      this.homeService.getUserByUserName(c).subscribe(data=> {
        this.user=data
        console.log("user:"+this.user.id);
      })
  }
  }
  updateUser(user: User){
    sessionStorage.getItem('username');
    this.router.navigate(['update-profile'])
  }
}
