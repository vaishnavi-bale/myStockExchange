import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockExchange } from '../models/stock-exchange';

@Injectable({
  providedIn: 'root'
})
export class StockExchangeService {
  httpUrl='http://localhost:8003/stockexchange/';
  constructor(private httpClient:HttpClient) { }
  getAllStockExchange(): Observable<StockExchange[]>{
    return this.httpClient.get<StockExchange[]>(this.httpUrl);
  }
  saveStockExchange(stockexchange: StockExchange): Observable<StockExchange>{
    return this.httpClient.post<StockExchange>(this.httpUrl , stockexchange);
  }
  deleteStockExchange(id: number): Observable<StockExchange> {
    return this.httpClient.delete<StockExchange>(this.httpUrl + id);
  }
  updateStockExchange(stockexchange: StockExchange):Observable<StockExchange>{
    return this.httpClient.put<StockExchange>(this.httpUrl,stockexchange);
    }
    getStockExchangeById(id: number):Observable<StockExchange>{
      return this.httpClient.get<StockExchange>(this.httpUrl+id);
    }
}
