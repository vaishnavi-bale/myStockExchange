import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { StockPrice } from '../models/stockprice';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  httpUrl = environment.url+"stock-price-service/stockprices/";

  constructor(private httpClient:HttpClient) { }

  uploadStocksSheet(formData:  FormData):Observable<void>{
    return this.httpClient.post<void>(this.httpUrl+"uploadStockSheet",formData);
  }

  getCompanyStockPricesBetween(companyCode: String,stockExchange:String,startDate:Date,endDate:Date):Observable<any[]>{
   let url="companyStockPriceBetween/"+companyCode+"/"+stockExchange+"/"+startDate+"/"+endDate;
    return this.httpClient.get<any[]>(this.httpUrl+url);
  }
}
