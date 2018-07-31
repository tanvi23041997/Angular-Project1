import { Component, OnInit } from '@angular/core';
import { DataService } from '../../myservices/dataservice.service';

@Component({
  selector: 'app-delete-schedule',
  templateUrl: './delete-schedule.component.html',
  styleUrls: ['./delete-schedule.component.css']
})
export class DeleteScheduleComponent implements OnInit {

  courses:any = [];
  semester: any = [];
  constructor(public ds : DataService) {
  this.ds.getAllCourses().subscribe(
    (response) => {
        console.log(response);
        this.courses = response;
    }
  );
}

onCourseChange(deleteScheduleform){
  //console.log(studregform.value);
  this.ds.getSemester(deleteScheduleform.value.courseId).subscribe(
    (response) => {
      this.semester = response;
    }
  );
}
  ngOnInit() {
  }

}
