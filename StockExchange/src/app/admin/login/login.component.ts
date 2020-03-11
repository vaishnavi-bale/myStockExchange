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
        userName: ['',Validators.required],
        password: ['',Validators.required],
    });

    this.homeService.getAllUsers().subscribe(u => {
      this.users=u;
    })
  }

//  isValid(){
//    let admin_userName="admin";
//    let admin_password="admin";
//   let userName=this.loginForm.controls.name.value;
//   let password=this.loginForm.controls.password.value;

//    if((userName===admin_userName) && (password===admin_password)){
//      this.router.navigate(['/main']);
//    }else{
//      if(this.login(userName,password)){
//       if(this.homeService.isActivated(this.currentUser)){
//         localStorage.removeItem('userId');
//         localStorage.setItem('userId',this.currentUser.id.toString());
//      this.router.navigate(['/user-main']);
//        }else{
//          alert("Please activate your account to login")
//        }
//      }else{
//        alert("Invalid Username or Password");
//        this.loginForm.reset();
//      }
//    }
//  }

  loginUser(userName:string,password:string){
      for(let user of this.users ){
        if((userName===user.userName) && (password===user.password)){
             this.currentUser=user;
          return true;
        }
      }
      return false;
  }

  login(){
    let userName=this.loginForm.controls.userName.value;
    let password=this.loginForm.controls.password.value;
    const result$=this.authService.authenticate(userName,password);
    result$.subscribe(data=>{
      console.log(data);
      sessionStorage.setItem('userId',data.id.toString());
    if(data.role=='ROLE_ADMIN'){
      this.router.navigate(['/main']);
    }
    else{
      this.router.navigate(['/user-main']);
    }
    })
    // if(this.loginUser(userName,password)){
    // if(this.homeService.isActivated(this.currentUser)){
    //   sessionStorage.removeItem('userId');
    //   sessionStorage.setItem('userId',this.currentUser.id.toString());
    //   this.authService.authenticate(userName,password).subscribe(u => {
    //     this.currentUser=u;
    //     if(this.currentUser.role=="ROLE_ADMIN"){
    //       this.router.navigate(['/main'])
    //     }else{
    //       this.router.navigate(['/user-main'])
    //     }
        
    //   });
    // }
    // }
  }
}
