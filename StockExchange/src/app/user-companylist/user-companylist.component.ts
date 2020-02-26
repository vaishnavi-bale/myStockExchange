import { Component, OnInit } from '@angular/core';
import { Company } from '../models/company';
import { CompanyService } from '../services/company.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-companylist',
  templateUrl: './user-companylist.component.html',
  styleUrls: ['./user-companylist.component.css']
})
export class UserCompanylistComponent implements OnInit {
  company:Company[];
  constructor(private companyService:CompanyService,private router: Router) { }

  ngOnInit() {
      
    this.companyService.getAllCompany().subscribe(data => {
      this.company=data;
      })
  }

}
