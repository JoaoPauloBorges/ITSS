import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { PageNotFoundComponent } from '../core/errors/page-not-found/page-not-found.component';
import { AuthGuard } from '../core/auth/auth.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ContentNotFoundComponent } from '../core/errors/content-not-found/content-not-found.component';
import { VehicleRegistrationComponent } from './vehicle-registration/vehicle-registration.component';
import { ParkingRegistrationComponent } from './parking-registration/parking-registration.component';

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: '',
        component: DashboardComponent
      },
      {
        path: 'vehicle-registration',
        component: VehicleRegistrationComponent
      },
      {
        path: 'parking-register',
        component: ParkingRegistrationComponent
      },
      {
        path: '**',
        component: ContentNotFoundComponent
      }
    ],
    canActivate: [AuthGuard]
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
