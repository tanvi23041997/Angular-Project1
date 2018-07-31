import { Component, OnInit } from '@angular/core';
import { DataService } from '../../myservices/dataservice.service';

@Component({
  selector: 'app-add-login',
  templateUrl: './add-login.component.html',
  styleUrls: ['./add-login.component.css']
})
export class AddLoginComponent implements OnInit {

  constructor(public ds : DataService) { }

  ngOnInit() {
  }

onAddLogin(loginform){
  this.ds.addNewLogin(loginform.value)
  .subscribe(
  (response)=>{
  console.log(response)
  }
  )
  }

}
