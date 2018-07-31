import { Component, OnInit } from '@angular/core';
import { DataService } from '../myservices/dataservice.service';

@Component({
  selector: 'app-student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.css']
})
export class StudentRegistrationComponent implements OnInit {

  courses:any = [];
  streams: any = [];
  constructor(public ds : DataService ) {
    this.ds.getAllCourses().subscribe(
      (response) => {
          console.log(response);
          this.courses = response;
      }
    );
  }

  ngOnInit() {
  }

  onCourseChange(studregform){
    //console.log(studregform.value);
    this.ds.getStreams(studregform.value.courseId).subscribe(
      (response) => {
        this.streams = response;
        console.log(this.streams);
      }
    );
  }

  onAddStudent(studregform){
  this.ds.regStudent(studregform.value)
  .subscribe(
    (response)=>{
      console.log(response);
    }
  )
  console.log("this is my message");
}
}
