import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manage-exchange',
  templateUrl: './manage-exchange.component.html',
  styleUrls: ['./manage-exchange.component.css']
})
export class ManageExchangeComponent implements OnInit {
  stockExchange:FormGroup;
  constructor(private formBuilder:FormBuilder,private router:Router) { }
 
  ngOnInit() {
    this.stockExchange=this.formBuilder.group({
      id:[],
      name:['',Validators.required],
      brief:[''],
      address:['',Validators.required],
      remarks:['']
    });
  }
  // stockExchanges(){
  //   this.stockEService.saveStockExchange(this.stockExchange.value).subscribe(data=>{
  //     alert('Stock Exchange Inserted Successfully.');
  //     this.router.navigate(['/manage-stock-exchange']);
  //   });
  // }

}
