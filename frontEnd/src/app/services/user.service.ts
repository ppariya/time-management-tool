import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = 'http://localhost:8080';
  public loggedInUser: User;

  constructor(private httpClient: HttpClient) {
  }

  signup(user: User) {
    this.httpClient.post<User>(`${this.url}/users`, user)
      .subscribe(console.log);
  }
  signin(user: User) {
    this.httpClient.post<User>(`${this.url}/signin`, user)
      .subscribe(response => this.loggedInUser = response);
  }

  logout() {
    this.httpClient.get(`${this.url}/logout`).subscribe();
  }

  getSignedInUser() {
    this.httpClient.get<User>(`${this.url}/loggedin`)
      .subscribe(response => this.loggedInUser = response);
  }
}
