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
import { CompanylistComponent } from './company/companylist/companylist.component'

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
    CompanylistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
