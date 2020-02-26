import { Component, OnInit } from '@angular/core';
import { Ipo } from '../models/ipo';
import { IpoService } from '../services/ipo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-ipolist',
  templateUrl: './user-ipolist.component.html',
  styleUrls: ['./user-ipolist.component.css']
})
export class UserIpolistComponent implements OnInit {
  ipodetails:Ipo[];
  constructor(private IpoService:IpoService,private router:Router) { }

  ngOnInit() {
    this.IpoService.getAllIpo().subscribe(data => {
      this.ipodetails=data;
    })
  }

}
