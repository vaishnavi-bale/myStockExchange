import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-import-data',
  templateUrl: './import-data.component.html',
  styleUrls: ['./import-data.component.css']
})
export class ImportDataComponent implements OnInit {
   uploadFile: FormGroup
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.uploadFile=this.formBuilder.group({
      file:['']
    })
  }

}
