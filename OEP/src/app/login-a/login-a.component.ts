import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-a',
  templateUrl: './login-a.component.html',
  styleUrls: ['./login-a.component.css']
})
export class LoginAComponent implements OnInit {

  constructor(public route : Router) { }

  ngOnInit() {
  }
  onLogin(loginForm){
    if(loginForm.value.auser =="admin"  && loginForm.value.pass)
      this.route.navigate(['adminHome']);
    else
    document.getElementById("error").innerHTML="INVALID CREDENTIALS";
      
      
  }

}
