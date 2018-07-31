import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../myservices/dataservice.service';

@Component({
  selector: 'app-faculty-registration',
  templateUrl: './faculty-registration.component.html',
  styleUrls: ['./faculty-registration.component.css']
})
export class FacultyRegistrationComponent implements OnInit {
  constructor(public ds : DataService ,public route:Router) { 
   
  }
  onRegister(regForm){
    if(regForm.valid){
      this.ds.addNewTeacher(regForm.value)
      .subscribe(
        (response) => { 
          console.log(response);
         // this.route.navigate(['home'])
        }
      )
      this.route.navigate(['home']);
    }
    else{
      document.getElementById("errors").innerHTML="INVALID INFORMATION";
    }

  }
  ngOnInit() {
  }

}
