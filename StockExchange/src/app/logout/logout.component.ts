import { Component, OnInit } from '@angular/core';
import { HomeService } from '../home.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
   localStorage.removeItem('userId')
   alert("Logged out Successfully")
    this.router.navigate(['/login'])
  }

}
