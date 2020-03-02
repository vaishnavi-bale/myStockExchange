import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  httpUrl='http://localhost:8001/user/';
  constructor(private httpClient:HttpClient) { }

  LoggedIn(){
    let user_id=localStorage.getItem('userId');
    if(user_id==null)
    return false;
    else return true;
  }

  getAllUsers(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.httpUrl);
  }
  saveUser(user: User): Observable<User>{
    return this.httpClient.post<User>(this.httpUrl , user);
  }
  deleteUser(id: number): Observable<User> {
    return this.httpClient.delete<User>(this.httpUrl + '/' + id);
  }
  updateUser(user: User):Observable<User>{
    return this.httpClient.put<User>(this.httpUrl,user);
    }
    getUserById(id: number):Observable<User>{
      return this.httpClient.get<User>(this.httpUrl+id);
    }
    getUserByCode(code:number):Observable<User>{
      return this.httpClient.get<User>(this.httpUrl+"activate/"+code);
    }
    // serviceActivation(obj){
    //   return this.httpClient.put(`http://localhost:8002/activate`,obj)
    // }
    // updateActivation(obj){
    //   return this.httpClient.put<User>(this.httpUrl,obj);
    // }
}
