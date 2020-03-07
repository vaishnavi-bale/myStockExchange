import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { UploadService } from 'src/app/services/upload.service';

@Component({
  selector: 'app-import-data',
  templateUrl: './import-data.component.html',
  styleUrls: ['./import-data.component.css']
})
export class ImportDataComponent implements OnInit {
   uploadFile: FormGroup;
   file:File;
   isError:boolean=false;
   errorMessage:string="";
  constructor(private formBuilder: FormBuilder,private uploadService:UploadService) { }

  ngOnInit() {
    // this.uploadFile=this.formBuilder.group({
    //   file:['']
    // })
    // bsCustomFileInput.init();
    this.uploadFile=new FormGroup({
      file:new FormControl("",[Validators.required])
    })
  }
  onFileChange(e){
    this.file=e.target.files[0];
  }

  uploadData(){
    const uploadSheetData=new FormData();
    uploadSheetData.append("stocksSheet",this.file,this.file.name);
    this.uploadService.uploadStocksSheet(uploadSheetData).subscribe(data => {
      console.log("Uploaded");
    })
  }
}
