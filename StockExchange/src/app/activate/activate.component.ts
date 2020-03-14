import { Component, OnInit, Inject } from '@angular/core';
import { HomeService } from '../home.service';
import { User } from '../models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-activate',
  templateUrl: './activate.component.html',
  styleUrls: ['./activate.component.css']
})
export class ActivateComponent implements OnInit {
  code: number;
  user: User;
  activate:boolean;
  constructor(private homeService:HomeService,private router:Router) { }

  ngOnInit() {
    let urls=this.router.url.split("=");
    this.code= +urls[1];
    this.activate_user();
   
  }
activate_user(){
  this.homeService.getUserByCode(this.code).subscribe(u => {
    this.user = u;
    this.update_user();
  })
}
update_user(){
  let new_user:User = this.user;
  new_user.active=true;
  this.homeService.updateUser(new_user).subscribe(u => {
    this.activate=true;
  })
}
}
