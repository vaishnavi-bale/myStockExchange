import { Component } from '@angular/core';
import { User } from './models/user';
import { HomeService } from './home.service';
// import { getMaxListeners } from 'cluster';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private homeService:HomeService){}
  title = 'myStockExchange';

}
