import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Company } from '../models/company';
import { CompanyService } from '../services/company.service';

@Component({
  selector: 'app-compare-company',
  templateUrl: './compare-company.component.html',
  styleUrls: ['./compare-company.component.css']
})
export class CompareCompanyComponent implements OnInit {
  compareCompany:FormGroup;
  companies:Company[];
  constructor(private formBuilder:FormBuilder,private router:Router,private companyService:CompanyService) { }

  ngOnInit() {
    this.compareCompany=this.formBuilder.group({
      "selectCompany":['',Validators.required],
      "selectStock":['',Validators.required],
      "companyName1":['',Validators.required],
      "companyName2":['',Validators.required],
      "from_period":['',Validators.required],
      "to_period":['',Validators.required]
    });
    this.companyService.getAllCompany().subscribe(data=>{
      this.companies=data;
    });
  }

  onSubmit(){
    this.router.navigate(["/chart"],{
      queryParams:{
        formData:JSON.stringify(this.compareCompany.value)
      }
    })
  }
}
