import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { IpoService } from '../services/ipo.service';
import { Router } from '@angular/router';
import { Ipo } from '../models/ipo';

@Component({
  selector: 'app-update-ipo',
  templateUrl: './update-ipo.component.html',
  styleUrls: ['./update-ipo.component.css']
})
export class UpdateIpoComponent implements OnInit {
  updateipo:FormGroup;
  constructor(private formBuilder:FormBuilder,private ipoService:IpoService,private router:Router) { }

  ngOnInit() {
    this.updateipo=this.formBuilder.group({
      id: ['',Validators.required],
      name: ['',Validators.required],
      stckExchange:['',Validators.required],
      pricePerShare:['',Validators.required],
      noOfShares:['',Validators.required],
      dateTime:['',Validators.required],
      remarks:['',Validators.required]
  })
  const id=localStorage.getItem('ipoId');
  if(+ id>0){
    this.ipoService.getIpoById(+id).subscribe(ipo => {
      this.updateipo.patchValue(ipo);
    })
  }
}
UpdateTheIpo(ipo: Ipo){
 this.ipoService.updateIpo(this.updateipo.value).subscribe(ipo=>{
   this.router.navigate(['/ipo-table']);
 })
}
back(){
  this.router.navigate(['main'])
}
}
