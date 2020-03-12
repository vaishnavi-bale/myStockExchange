import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { IpoService } from 'src/app/services/ipo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ipo-details',
  templateUrl: './ipo-details.component.html',
  styleUrls: ['./ipo-details.component.css']
})
export class IpoDetailsComponent implements OnInit {
  ipoDetails:FormGroup;
  constructor(private formBuilder:FormBuilder,private ipoService:IpoService,private router:Router) { }

  ngOnInit() {
    this.ipoDetails=this.formBuilder.group({
    
      name: ['',Validators.required],
      stckExchange:['',Validators.required],
      pricePerShare:['',Validators.required],
      noOfShares:['',Validators.required],
      dateTime:['',Validators.required],
      remarks:['',Validators.required]
  })
}
  AddIpo(){
    this.ipoService.saveIpo(this.ipoDetails.value).subscribe(data => {
      alert("Ipo Details entered successfully");
      this.router.navigate(['ipo-table'])
    })
  }
  back(){
    this.router.navigate(['main'])
  }

}
