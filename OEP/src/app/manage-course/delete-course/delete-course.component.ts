import { Component, OnInit } from '@angular/core';
import { DataService } from '../../myservices/dataservice.service';

@Component({
  selector: 'app-delete-course',
  templateUrl: './delete-course.component.html',
  styleUrls: ['./delete-course.component.css']
})
export class DeleteCourseComponent implements OnInit {
  public courses: any=[];
  constructor(public ds : DataService) {
  
  this.ds.getAllCourses()
  .subscribe(
      response => {
      console.log("Getting Courses...");
      this.courses=response;
      }
  );
 }

  ngOnInit() {}

}
