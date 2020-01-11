import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Patio } from '../patio/patio';

@Component({
  selector: 'app-patio-list',
  templateUrl: './patio-list.component.html',
  styleUrls: ['./patio-list.component.scss']
})
export class PatioListComponent implements OnInit {

  patios: Patio[];
  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

}
