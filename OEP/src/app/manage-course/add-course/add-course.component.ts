import { Component, OnInit } from '@angular/core';
import { DataService } from '../../myservices/dataservice.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  constructor(public ds : DataService) { }

  ngOnInit() {
  }

onAddCourse(courseAddform){
  if(courseAddform.valid){
    this.ds.addNewCourse(courseAddform.value)
      .subscribe(
      (response)=>{
      console.log(response)
      }
    )
  }
  else
  document.getElementById("chkerror").innerHTML="INVALID CREDENTIALS";
}
}