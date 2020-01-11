import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParkingRegistrationComponent } from './parking-registration.component';

describe('ParkingRegistrationComponent', () => {
  let component: ParkingRegistrationComponent;
  let fixture: ComponentFixture<ParkingRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParkingRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParkingRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
