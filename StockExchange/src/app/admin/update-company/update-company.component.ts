import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CompanyService } from 'src/app/services/company.service';
import { Router } from '@angular/router';
import { Company } from 'src/app/models/company';

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {
  updateCompany: FormGroup;
  constructor(private formBuilder: FormBuilder, private companyService: CompanyService,private router: Router) { }

  ngOnInit() {
    this.updateCompany=this.formBuilder.group({
      id:[],
      companyName: ['',Validators.required],
      ceoName:['',Validators.required],
      boardMember:['',Validators.required],
      turnOver:['',Validators.required],
      briefDescription:['',Validators.required],
      ipoDate:['',Validators.required]
    });
  const id = localStorage.getItem('companyId');
    if (+ id > 0) {
      this.companyService.getCompanyById(+id).subscribe(company => {
        this.updateCompany.patchValue(company);
      })
    }
  }
  updateTheCompany(company: Company){
    this.companyService.updateCompany(this.updateCompany.value).subscribe(u=>{
      this.router.navigate(['/company-list']);
    })
  }
  back(){
    this.router.navigate(['main'])
  }
}

