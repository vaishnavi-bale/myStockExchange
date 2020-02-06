import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/models/company';
import { CompanyService } from 'src/app/services/company.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-companylist',
  templateUrl: './companylist.component.html',
  styleUrls: ['./companylist.component.css']
})
export class CompanylistComponent implements OnInit {
  company:Company[];
  constructor(private companyService:CompanyService,private router: Router) { }
  
  ngOnInit() {
    
    this.companyService.getAllCompany().subscribe(data => {
      this.company=data;
    })
  }
  deleteCompany(company: Company){
    this.companyService.deleteCompany(company.id).subscribe();
    this.company=this.company.filter(u => u !== company );
  }
  updateCompany(company: Company){
    localStorage.removeItem('companyId');
    localStorage.setItem('companyId',company.id.toString());
    this.router.navigate(['/update-company'])
  }
}
