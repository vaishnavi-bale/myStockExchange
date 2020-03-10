import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { CompanyService } from 'src/app/services/company.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  companyForm: FormGroup;
  constructor(private formBuilder:FormBuilder,private companyService:CompanyService,private router:Router) { }

  ngOnInit() {
    this.companyForm=this.formBuilder.group({
      id: ['',Validators.required],
      companyName: ['',Validators.required],
      ceoName:['',Validators.required],
      boardMember:['',Validators.required],
      listed_in_stock_exchanges:['',Validators.required],
      sector:['',Validators.required],
      turnOver:['',Validators.required],
      briefDescription:['',Validators.required],
      stock_code:['',Validators.required]
    });
  }
  addCompanyMethod(){
    alert('Added company')
    this.companyService.saveCompany(this.companyForm.value).subscribe(data => {
      console.log('Company Inserted Successfully')
    });
  }
  back(){
    this.router.navigate(['main']);
  }
}
