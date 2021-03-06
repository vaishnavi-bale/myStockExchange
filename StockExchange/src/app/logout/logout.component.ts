import { Component, OnInit } from '@angular/core';
import { HomeService } from '../home.service';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {
logout:boolean;
  constructor(private router:Router,private authService:AuthService) { }

  ngOnInit() {
   this.authService.logout();
   this.logout=true;
    // this.router.navigate(['/login'])
  }

}
