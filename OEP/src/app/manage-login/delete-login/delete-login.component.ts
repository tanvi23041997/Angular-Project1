import { Component, OnInit } from '@angular/core';
import { DataService } from '../../myservices/dataservice.service';

@Component({
  selector: 'app-delete-login',
  templateUrl: './delete-login.component.html',
  styleUrls: ['./delete-login.component.css']
})
export class DeleteLoginComponent implements OnInit {
  public logins: any=[];
  constructor(public ds:DataService) { 
    this.ds.getAllLogins()
    .subscribe(
      response => {
      this.logins=response;
      }
  );
  }
  onDeleteCourse(delschform){
    this.ds.deleteLogin(delschform.value.user)
    .subscribe(
      response => {
        console.log(response);
      }
    )
  }

  ngOnInit() {
  }

}
