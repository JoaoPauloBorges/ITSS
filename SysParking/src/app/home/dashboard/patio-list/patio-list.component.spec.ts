import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatioListComponent } from './patio-list.component';

describe('PatioListComponent', () => {
  let component: PatioListComponent;
  let fixture: ComponentFixture<PatioListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatioListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatioListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
