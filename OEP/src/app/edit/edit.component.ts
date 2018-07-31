import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../myservices/dataservice.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  teachers:any=[];
  currentTeach;
  teacherDetails: FormGroup;
    constructor(public ds : DataService) { 
      this.teacherDetails=new FormGroup({
        teacherName : new FormControl(),
        highQual : new FormControl(),
        teacherEmail : new FormControl(),
        teacherContact : new FormControl(),
        teacherAddress : new FormControl(),
        teacherExperience : new FormControl(),
        rating : new FormControl(),
      });
      
      ds.getAllTeacher()
      .subscribe(
        (response) => {
          this.teachers=response;
          console.log(this.teachers)
        });
    }
  getTeacher(teacherName){
    for(const teach of this.teachers){
      if(teach.teacherName==teacherName){
        this.currentTeach=teach;
        break;
      }
      else{
        this.currentTeach="not present"
      }
    }
    if(this.currentTeach){
      this.teacherDetails.get('teacherName').setValue(this.currentTeach.teacherName);
      this.teacherDetails.get('highQual').setValue(this.currentTeach.highQual);
      this.teacherDetails.get('teacherEmail').setValue(this.currentTeach.teacherEmail);
      this.teacherDetails.get('teacherContact').setValue(this.currentTeach.teacherContact);
      this.teacherDetails.get('teacherAddress').setValue(this.currentTeach.teacherAddress);
      this.teacherDetails.get('teacherExperience').setValue(this.currentTeach.teacherExperience);
      this.teacherDetails.get('rating').setValue(this.currentTeach.rating);
    }
  }

  ngOnInit() {
  }
  onUpdate(){
    console.log(this.teacherDetails.value);
     console.log("update");
    this.ds.updateTeacher(this.teacherDetails.value)
    .subscribe(
    (response)=>{
    console.log(response)
    })
   }
}
