import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../myservices/dataservice.service';

@Component({
  selector: 'app-login-t',
  templateUrl: './login-t.component.html',
  styleUrls: ['./login-t.component.css']
})
export class LoginTComponent implements OnInit {
  invalidUser = false;

  constructor(public route: Router, public ds: DataService) { }

  onLogin(loginTForm) {

     if (this.ds.checkLogin(loginTForm.value) === 1) {
         this.route.navigate(['thome']);
     }
     else{
       document.getElementById("error").innerHTML="INVALID USER";
     }
   }

  ngOnInit() {
  }

}
