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
  //   let c = sessionStorage.getItem('userName');
  //   console.log(c)
  //   if (+ c > 0) {
  //     this.homeService.getUserByUserName(+c).subscribe(data=> {
  //       this.user=data
  //       console.log("user:"+this.user);
  //     })
  // }
  }
}
