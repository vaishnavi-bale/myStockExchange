import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { HomeService} from 'src/app/home.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  addForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private homeService: HomeService) { }

  ngOnInit() {
    this.addForm=this.formBuilder.group({
      id: ['',Validators.required],
      fullName: ['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      phoneNumber:['',Validators.required],
      userName:['',Validators.required],
      password:['',Validators.required]
    });

  }
  addUserMethod(){
    this.homeService.saveUser(this.addForm.value).subscribe(data => {
      console.log('User Inserted Successfully')
    });
  }
  onSubmit(){
    console.log(this.addForm.value);
  }
}
