import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts';
import { CompareCompanyComponent } from '../compare-company/compare-company.component';
import { ActivatedRoute } from '@angular/router';
import { UploadService } from '../services/upload.service';
import { StockPriceData } from '../models/stockprice-data';

@Component({
  selector: 'app-charts',
  templateUrl: './charts.component.html',
  styleUrls: ['./charts.component.css']
})
export class ChartsComponent implements OnInit {
   compareData:any;
   constructor(private stockPriceService: UploadService, private route: ActivatedRoute) { }
   chartOne = Highcharts;
   chartOneOptions: any;
   getFirstDataComplete: boolean = false;
   getSecondDataComplete: boolean = false;
   ngOnInit() {
       this.compareData = JSON.parse(this.route.snapshot.queryParams.formData);
       let series: any = []
           let categories: any[] = [];
           this.stockPriceService.getCompanyStockPricesBetween(this.compareData.companyName1, this.compareData.selectStock, this.compareData.from_period, this.compareData.to_period).subscribe(data => {
               let companyOneData: any[] = [];
               data.forEach((stockPrice) => {
                   categories.push(stockPrice.dataPoint);
                   companyOneData.push(stockPrice.dataValue)
               })
               let seriesDataMemberOne = {
                   name: this.compareData.companyName1 + " (" + this.compareData.selectStock + ")",
                   data: companyOneData
               }
               series[0] = seriesDataMemberOne;
               this.getFirstDataComplete = true;
           });
           this.stockPriceService.getCompanyStockPricesBetween(this.compareData.companyName2, this.compareData.selectStock,this.compareData.from_period, this.compareData.to_period).subscribe(data => {
               let companyTwoData: any[] = [];
               data.forEach((stockPrice) => {
                   if (categories.includes(stockPrice.dataPoint)) {
                       companyTwoData.push(stockPrice.dataValue)
                   }
               })
               let seriesDataMemberTwo = {
                   name: this.compareData.companyName2 + " (" + this.compareData.selectStock + ")",
                   data: companyTwoData
               }
               series[1] = seriesDataMemberTwo;
               this.getSecondDataComplete = true;
           });
           this.chartOneOptions = {
               chart: {
                   type: "column"
               },
               title: {
                   text: "Stock Comparision Chart"
               },
               xAxis: {
                   categories: categories
               },
               yAxis: {
                   title: {
                       text: "Stock Price"
                   }
               },
               series: series
           }
       }

//   constructor() { }

//   ngOnInit() {
//   }
//   title = 'myHighchart';
//   data = [{
//           name: 'ItSolutionStuff.com',
//           data: [500, 700, 555, 444, 777, 877, 944, 567, 666, 789, 456, 654]
//        },{
//           name: 'Nicesnippets.com',
//           data: [677, 455, 677, 877, 455, 778, 888, 567, 785, 488, 567, 654]
//        }];
//   highcharts = Highcharts;
//   chartOptions = {   
//     chart: {
//        type: "spline"
//     },
//     title: {
//        text: "Monthly Site Visitor"
//     },
//     xAxis:{
//        categories:["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
//     },
//     yAxis: {          
//        title:{
//           text:"Visitors"
//        } 
//     },
//     series: this.data
//   };

}
