import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  companyForm: FormGroup;
  constructor(private formBuilder:FormBuilder,private companyService:CompanyService) { }

  ngOnInit() {
    this.companyForm=this.formBuilder.group({
      idNumber: ['',Validators.required],
      companyName: ['',Validators.required],
      ceoName:['',Validators.required],
      boardMember:['',Validators.required],
      turnOver:['',Validators.required],
      briefDescription:['',Validators.required],
      ipoDate:['',Validators.required]
    });
  }
  addCompanyMethod(){
    alert('Added company')
    this.companyService.saveCompany(this.companyForm.value).subscribe(data => {
      console.log('Company Inserted Successfully')
    });
  }
  onSubmit(){
    console.log(this.companyForm.value);
  }
}
