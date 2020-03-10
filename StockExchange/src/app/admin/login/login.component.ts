import { Component, OnInit } from '@angular/core';
import { User} from 'src/app/models/user';
import { FormGroup,FormControl, Validators, FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { HomeService } from 'src/app/home.service';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   loginForm:FormGroup;
   users:User[];
   currentUser:User;
  constructor(private formBuilder:FormBuilder,private router:Router,private homeService:HomeService,private authService:AuthService) { }
  
  ngOnInit() {
    this.loginForm=this.formBuilder.group({
        name: ['',Validators.required],
        password: ['',Validators.required],
    });

    this.homeService.getAllUsers().subscribe(u => {
      this.users=u;
    })
  }

 isValid(){
   let admin_userName="admin";
   let admin_password="admin";
  let userName=this.loginForm.controls.name.value;
  let password=this.loginForm.controls.password.value;

   if((userName===admin_userName) && (password===admin_password)){
     this.router.navigate(['/main']);
   }else{
     if(this.login(userName,password)){
      if(this.homeService.isActivated(this.currentUser)){
        localStorage.removeItem('userId');
        localStorage.setItem('userId',this.currentUser.id.toString());
     this.router.navigate(['/user-main']);
       }else{
         alert("Please activate your account to login")
       }
     }else{
       alert("Invalid Username or Password");
       this.loginForm.reset();
     }
   }
 }

  login(userName:string,password:string){
      for(let user of this.users ){
        if((userName===user.userName) && (password===user.password)){
             this.currentUser=user;
          return true;
        }
      }
      return false;
  }


  onSubmit(){
    console.log(this.loginForm.value);
     
  }

  // login(){
  //   let userName
  // }
  
}
