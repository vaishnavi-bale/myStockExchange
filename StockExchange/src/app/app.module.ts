import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './admin/login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MainComponent } from './admin/main/main.component';
import { ImportDataComponent } from './admin/import-data/import-data.component';
import { SignupComponent } from './admin/signup/signup.component';
import { CompanyComponent } from './admin/company/company.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import { UpdateComponent } from './update/update.component';
import { CompanylistComponent } from './company/companylist/companylist.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { IpoDetailsComponent } from './admin/ipo-details/ipo-details.component';
import { UserMainComponent } from './user-main/user-main.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { CompareCompanyComponent } from './compare-company/compare-company.component';
import { UpdateIpoComponent } from './update-ipo/update-ipo.component';
import { IpoTableComponent } from './ipo-table/ipo-table.component';
import { CompareSectorComponent } from './compare-sector/compare-sector.component';
import { StocklistComponent } from './stocklist/stocklist.component';
import { UpdateExchangeComponent } from './update-exchange/update-exchange.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { UserCompanylistComponent } from './user-companylist/user-companylist.component';
import { UserIpolistComponent } from './user-ipolist/user-ipolist.component';
import { ActivateComponent } from './activate/activate.component';
import { LogoutComponent } from './logout/logout.component';
import { ChartsComponent } from './charts/charts.component';
import {HighchartsChartComponent} from 'highcharts-angular';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchComponent } from './search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    ImportDataComponent,
    SignupComponent,
    CompanyComponent,
    UserComponent,
    HomeComponent,
    UpdateComponent,
    CompanylistComponent,
    ManageExchangeComponent,
    IpoDetailsComponent,
    UserMainComponent,
    UpdateCompanyComponent,
    CompareCompanyComponent,
    UpdateIpoComponent,
    IpoTableComponent,
    CompareSectorComponent,
    StocklistComponent,
    UpdateExchangeComponent,
    SidebarComponent,
    AboutUsComponent,
    ContactUsComponent,
    UserCompanylistComponent,
    UserIpolistComponent,
    ActivateComponent,
    LogoutComponent,
    ChartsComponent,
    HighchartsChartComponent,
    ProfileComponent,
    UpdateProfileComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
