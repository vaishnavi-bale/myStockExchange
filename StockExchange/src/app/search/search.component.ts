import { Component, OnInit } from '@angular/core';
import { Company } from '../models/company';
import { CompanyService } from '../services/company.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  companies:Company[];
  selected_company:Company;
  flag:boolean=false;
  constructor(private companyService:CompanyService) { }

  ngOnInit() {
  }
  onInputChange(e){
    this.companyService.getCompanyByPattern(e.target.value).subscribe(data => {
          this.companies = data;
    });
  }
  selectCompany(event){
    let company_name=event.target.value;
    this.companyService.getCompanyByName(company_name).subscribe(data=>{
      this.selected_company=data;
      this.flag=true;
    })
  }
}
