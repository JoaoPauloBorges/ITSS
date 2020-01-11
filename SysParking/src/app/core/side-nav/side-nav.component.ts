import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.scss']
})
export class SideNavComponent implements OnInit {

  visibleSidebar = false;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  registrationClick() {
    this.router.navigateByUrl('home/vehicle-registration', { skipLocationChange: false });
    this.visibleSidebar = false;
  }

}
