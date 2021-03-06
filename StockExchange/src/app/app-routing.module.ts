import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './admin/login/login.component';
import { SignupComponent } from './admin/signup/signup.component';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import { MainComponent } from './admin/main/main.component';
import { ImportDataComponent } from './admin/import-data/import-data.component';
import { CompanyComponent } from './admin/company/company.component';
import { UpdateComponent } from './update/update.component';
import { ManageExchangeComponent } from './admin/manage-exchange/manage-exchange.component';
import { IpoDetailsComponent } from './admin/ipo-details/ipo-details.component';
import { UserMainComponent } from './user-main/user-main.component';
import { CompanylistComponent } from './company/companylist/companylist.component';
import { UpdateCompanyComponent } from './admin/update-company/update-company.component';
import { CompareCompanyComponent } from './compare-company/compare-company.component';
import { UpdateIpoComponent } from './update-ipo/update-ipo.component';
import { IpoTableComponent } from './ipo-table/ipo-table.component';
import { CompareSectorComponent } from './compare-sector/compare-sector.component';
import { UpdateExchangeComponent } from './update-exchange/update-exchange.component';
import { StocklistComponent } from './stocklist/stocklist.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { UserCompanylistComponent } from './user-companylist/user-companylist.component';
import { UserIpolistComponent } from './user-ipolist/user-ipolist.component';
import { ActivateComponent } from './activate/activate.component';
import { LoginGuard } from './login.guard';
import { LogoutComponent } from './logout/logout.component';
import { ChartsComponent } from './charts/charts.component';
import { ProfileComponent } from './profile/profile.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  { path: '',redirectTo:'home',pathMatch:'full'}, 
{ path: 'user', component: UserComponent},
{ path: 'login', component: LoginComponent},
{ path: 'signup', component: SignupComponent},
{ path:'home',component: HomeComponent},
{path : 'main',component: MainComponent,canActivate:[LoginGuard]},
{path : 'import-data',component:ImportDataComponent},
{path: 'company',component:CompanyComponent},
{ path :'update',component:UpdateComponent},
{ path:'manage-exchange',component:ManageExchangeComponent},
{ path:'ipo-details',component:IpoDetailsComponent},
{path: 'user-main',component:UserMainComponent,canActivate:[LoginGuard]},
{path: 'company-list',component:CompanylistComponent},
{path: 'update-company',component:UpdateCompanyComponent},
{path:'compare-company',component:CompareCompanyComponent},
{path:'update-ipo',component:UpdateIpoComponent},
{path:'ipo-table',component:IpoTableComponent},
{path:'compare-sector',component:CompareSectorComponent},
{path:'update-exchange',component:UpdateExchangeComponent},
{path:'stock-list',component:StocklistComponent},
{path:'about-us',component:AboutUsComponent},
{path:'contact-us',component:ContactUsComponent},
{path:'user-companylist',component:UserCompanylistComponent},
{path:'user-ipolist',component:UserIpolistComponent},
{path:'user/activate',component:ActivateComponent},
{path:'logout',component:LogoutComponent},
{path:'chart',component:ChartsComponent},
{path:'update-profile',component:UpdateProfileComponent},
{path:'profile',component:ProfileComponent},
{path:'profile',component:ProfileComponent},
{path:'search',component:SearchComponent},
{ path: ' ',component:AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
