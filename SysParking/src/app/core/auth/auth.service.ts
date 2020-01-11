import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { UserService } from '../user/user.service';


const API_URL = 'http://localhost:8080';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    private userService: UserService) { }

  authenticate(username: string, password: string) {
    return this.http
      .post(API_URL + '/auth', { username, password }, { observe: 'response' })
      .pipe(tap(res => {
        // tslint:disable-next-line: no-string-literal
        const authToken = res.body['jwt'];
        this.userService.setToken(authToken);
        console.log(authToken);
      })
      );
  }
}
