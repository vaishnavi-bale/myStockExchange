import { Component, OnInit } from '@angular/core';
import { User} from 'src/app/models/user';
import { FormGroup,FormControl, Validators, FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   loginForm:FormGroup;
  constructor(private formBuilder:FormBuilder) { }
  
  ngOnInit() {
    this.loginForm=this.formBuilder.group({
        name: ['',Validators.required],
        password: ['',Validators.required],
    })
  }

  onSubmit(){
    console.log(this.loginForm.value);
     
  }
  
}
