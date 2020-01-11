import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import { PatioListComponent } from './patio-list/patio-list.component';
import { PatioComponent } from './patio/patio.component';
import { RegistrationComponent } from './registration/registration.component';



@NgModule({
  declarations: [
    DashboardComponent,
    PatioListComponent,
    PatioComponent,
    RegistrationComponent],
  imports: [
    CommonModule
  ],
  exports: [DashboardComponent]
})
export class DashboardModule { }
