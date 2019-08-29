import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }
  loginUser() {

  }
  signingUpUser() {
    console.log('signing up');
  }
  ngOnInit() {
  }

}
