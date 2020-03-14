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
  added:boolean;
  users:User[];
  exists:boolean;

  constructor(private formBuilder: FormBuilder, private homeService: HomeService) { }

  ngOnInit() {
    this.addForm=this.formBuilder.group({
      id: [],
      fullName: ['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      phoneNumber:['',Validators.required],
      userName:['',Validators.required],
      password:['',Validators.required],
      code:[Math.random()*100000]
    });

    this.homeService.getAllUsers().subscribe(u => {
      this.users=u;
    })

  }

 

  emailValid(e:string){
    if(this.users!=null){
    for(let user of this.users){
      if(user.email===e){
        return false;
      }
    }
      return true;
     }
     return true;
  }

  addUserMethod(){
    let e = this.addForm.controls.email.value;
    if(this.emailValid(e)){
      this.added=true;
      this.homeService.saveUser(this.addForm.value).subscribe(data => {
      });
     
    }else{
      this.exists=true;
      this.addForm.reset();
    }
   
  }
  onSubmit(){
    console.log(this.addForm.value);
  }
}
