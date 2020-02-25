import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { StockExchangeService } from '../services/stock-exchange.service';
import { Router } from '@angular/router';
import { StockExchange } from '../models/stock-exchange';

@Component({
  selector: 'app-update-exchange',
  templateUrl: './update-exchange.component.html',
  styleUrls: ['./update-exchange.component.css']
})
export class UpdateExchangeComponent implements OnInit {
  updateStockExchange:FormGroup;
  constructor(private stockExchangeService:StockExchangeService,private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.updateStockExchange=this.formBuilder.group({
      id:['',Validators.required],
      name:['',Validators.required],
      brief:['',Validators.required],
      address:['',Validators.required],
      remarks:['',Validators.required]
    })
    const id = localStorage.getItem('stockId');
    if (+ id > 0) {
      this.stockExchangeService.getStockExchangeById(+id).subscribe(stock => {
        this.updateStockExchange.patchValue(stock);
      })
    }
  }
  updateStocks(stock: StockExchange){
    this.stockExchangeService.updateStockExchange(this.updateStockExchange.value).subscribe(u=>{
      this.router.navigate(['/stock-list']);
    })

  }

}
