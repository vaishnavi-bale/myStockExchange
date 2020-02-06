import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Company } from '../models/company';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  httpUrl='http://localhost:8888/company/';
  constructor(private httpClient:HttpClient) { }
  getAllCompany(): Observable<Company[]>{
    return this.httpClient.get<Company[]>(this.httpUrl);
  }
  saveCompany(company: Company): Observable<Company>{
    return this.httpClient.post<Company>(this.httpUrl , company);
  }
  deleteCompany(idNumber: number): Observable<Company> {
    return this.httpClient.delete<Company>(this.httpUrl + idNumber);
  }
  updateCompany(company: Company):Observable<Company>{
    return this.httpClient.put<Company>(this.httpUrl + company.id ,company);
    }
    getCompanyById(idNumber: number):Observable<Company>{
      return this.httpClient.get<Company>(this.httpUrl+idNumber);
    }
}
