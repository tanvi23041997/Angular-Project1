import { Component, OnInit } from '@angular/core';
import { DataService } from '../../myservices/dataservice.service';

@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class AddScheduleComponent implements OnInit {

  courses:any = [];
  constructor(public ds : DataService) {
  this.ds.getAllCourses().subscribe(
    (response) => {
        console.log(response);
        this.courses = response;
    }
  );
}
onAddSchedule(scheduleAddform){
    if(scheduleAddform.valid){
      this.ds.addNewSchedule(scheduleAddform.value)
        .subscribe(
        (response)=>{
        console.log(response)
        }
      );  
    }
    else
    document.getElementById("chkerror").innerHTML="INVALID CREDENTIALS";
}

  ngOnInit() {
  }

}
