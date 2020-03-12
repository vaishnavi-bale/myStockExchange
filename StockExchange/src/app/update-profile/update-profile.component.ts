import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HomeService } from '../home.service';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {
  updateProfile: FormGroup;
  user:User;
  constructor(private formBuilder:FormBuilder,private homeService:HomeService,private router: Router){ }

  ngOnInit() {
    this.updateProfile = this.formBuilder.group({
      id: ['',Validators.required],
      fullName: ['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      phoneNumber:['',Validators.required],
      userName:['',Validators.required],
      password:['',Validators.required],
      active:[],
      code:[]
    });

    const c = sessionStorage.getItem('username');
    console.log(c)
    if (+ c !=null) {
      this.homeService.getUserByUserName(c).subscribe(data=> {
        this.updateProfile.patchValue(data);
      })

    }
  }
  updateTheUser(user: User){
    this.homeService.updateUser(this.updateProfile.value).subscribe(u=>{
      this.router.navigate(['profile']);
    })
  }
  back(){
    this.router.navigate(['profile'])
  }

}
