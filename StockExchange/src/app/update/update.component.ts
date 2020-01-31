import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HomeService } from '../home.service';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  updateUser: FormGroup;
  constructor(private formBuilder: FormBuilder, private homeService: HomeService,private router: Router) { }

  ngOnInit() {
    this.updateUser = this.formBuilder.group({
      id: ['',Validators.required],
      fullName: ['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      phoneNumber:['',Validators.required],
      userName:['',Validators.required],
      password:['',Validators.required]
    });

    const id = localStorage.getItem('userId');
    if (+ id > 0) {
      this.homeService.getUserById(+id).subscribe(user => {
        this.updateUser.patchValue(user);
      })

    }
  }
  updateTheUser(user: User){
    this.homeService.updateUser(this.updateUser.value).subscribe(u=>{
      this.router.navigate(['user']);
    })

  }

  }


