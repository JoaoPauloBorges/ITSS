import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from '../user/user.service';
import { Router } from '@angular/router';
import { User } from '../user/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {


  user$: Observable<User>;
  user: User;
  constructor(
    private userService: UserService,
    private router: Router) {
    this.user$ = userService.getUser();
    this.user$.subscribe(user => this.user = user);
  }

  ngOnInit() {
  }

  logout() {
    console.log('logout');
    this.userService.logout();
    this.router.navigateByUrl('');
  }


}
