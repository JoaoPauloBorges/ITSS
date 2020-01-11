import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { HomeRoutingModule } from './home-routing.module';
import { CoreModule } from '../core/core.module';
import { VehicleRegistrationComponent } from './vehicle-registration/vehicle-registration.component';
import { ParkingRegistrationModule } from './parking-registration/parking-registration.module';

@NgModule({
  declarations: [
    HomeComponent,
    VehicleRegistrationComponent
  ],
  imports: [
    CommonModule,
    DashboardModule,
    HomeRoutingModule,
    CoreModule,
    ParkingRegistrationModule
  ],
})
export class HomeModule { }
