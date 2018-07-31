import { Component, OnInit } from '@angular/core';
import { DataService } from '../myservices/dataservice.service';

@Component({
  selector: 'app-exam-shed',
  templateUrl: './exam-shed.component.html',
  styleUrls: ['./exam-shed.component.css']
})
export class ExamShedComponent implements OnInit {

  public schedule: any =[]
  constructor(public ds : DataService) { 
    this.ds.getAllSchedule()
    .subscribe(
      (response) => {
        console.log(response);
        this.schedule=response;
      }
    )
  }
  ngOnInit() {
  }

}
