import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { HomeService } from '../home.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
user:User;
  constructor(private homeService:HomeService) { }

  ngOnInit() {
    const c = localStorage.getItem('userId');
      this.homeService.getUserById(+c).subscribe(data =>{
        this.user=data;
    });
  }

}
