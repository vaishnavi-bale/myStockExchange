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

const routes: Routes = [
{ path: '',redirectTo:'home',pathMatch:'full'}, 
{ path: 'user', component: UserComponent},
{ path: 'login', component: LoginComponent},
{ path: 'signup', component: SignupComponent},
{ path:'home',component: HomeComponent},
{path : 'main',component: MainComponent},
{path : 'import-data',component:ImportDataComponent},
{path: 'company',component:CompanyComponent},
{ path :'update',component:UpdateComponent},
{ path: ' ',component:AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
