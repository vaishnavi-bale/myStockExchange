import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './models/user';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  httpUrl='http://localhost:8765/user-service/user/';
  code: number;
  user: User;
  constructor(private httpClient:HttpClient,private router:Router) { }

  LoggedIn(){
    let user_id=sessionStorage.getItem('userId');
    if(user_id==null)
    return false;
    else return true;
  }

  isActivated(user:User){
    if(user.active==true){
          return true;
    }
  }

  isUser(user:User){
    if(user.role=="ROLE_USER"){
      return true;
    }else return false;
  }
  // activate_user(){
  //   this.getUserByCode(this.code).subscribe(u => {
  //     this.user = u;
  //     this.update_user();
  //   })
  // }
  // update_user(){
  //   let new_user:User = this.user;
  //   new_user.active="yes";
  //   this.updateUser(new_user).subscribe(u => {
  //     alert("User Activated Successfully")
  //     this.router.navigate(['/login'])
  //   })
  // }

  getAllUsers(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.httpUrl);
  }
  saveUser(user: User): Observable<User>{
    return this.httpClient.post<User>(this.httpUrl , user);
  }
  deleteUser(id: number): Observable<User> {
    return this.httpClient.delete<User>(this.httpUrl + id);
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

    getUserByUserName(userName:String):Observable<User>{
      return this.httpClient.get<User>(this.httpUrl+'/'+userName)
    }
    // serviceActivation(obj){
    //   return this.httpClient.put(`http://localhost:8002/activate`,obj)
    // }
    // updateActivation(obj){
    //   return this.httpClient.put<User>(this.httpUrl,obj);
    // }
}
