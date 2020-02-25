import { Component, OnInit } from '@angular/core';
import { StockExchangeService } from '../services/stock-exchange.service';
import { Router } from '@angular/router';
import { StockExchange } from '../models/stock-exchange';

@Component({
  selector: 'app-stocklist',
  templateUrl: './stocklist.component.html',
  styleUrls: ['./stocklist.component.css']
})
export class StocklistComponent implements OnInit {
  stocks:StockExchange[];
  constructor(private stockExchangeService:StockExchangeService,private router:Router,) { }

  ngOnInit() {
    this.stockExchangeService.getAllStockExchange().subscribe(data => {
      this.stocks=data;
    })
  }
  deleteStock(stocks:StockExchange){
    this.stockExchangeService.deleteStockExchange(stocks.id).subscribe();
    this.stocks=this.stocks.filter(s => s !==stocks)
  }
  updateStock(stocks:StockExchange){
    localStorage.removeItem('stockId');
    localStorage.setItem('stockId',stocks.id.toString());
    this.router.navigate(['update-exchange']);
  }

}
