import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { StockExchangeService } from 'src/app/services/stock-exchange.service';

@Component({
  selector: 'app-manage-exchange',
  templateUrl: './manage-exchange.component.html',
  styleUrls: ['./manage-exchange.component.css']
})
export class ManageExchangeComponent implements OnInit {
  stockExchange:FormGroup;
  constructor(private formBuilder:FormBuilder,private router:Router,private stockExchangeService:StockExchangeService) { }
 
  ngOnInit() {
    this.stockExchange=this.formBuilder.group({
      name:['',Validators.required],
      brief:['',Validators.required],
      address:['',Validators.required],
      remarks:['',Validators.required]
    });
  }
   addStocks(){
    this.stockExchangeService.saveStockExchange(this.stockExchange.value).subscribe(data=>{
       alert('Stock Exchange Inserted Successfully.');
       })
      }
  back(){
    this.router.navigate(['main'])
  }
    }     
