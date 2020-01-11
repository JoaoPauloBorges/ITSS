import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header.component';
import { SideNavModule } from 'src/app/core/side-nav/side-nav.module';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [HeaderComponent],
  imports: [
    CommonModule,
    SideNavModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    SideNavModule
  ]
})
export class HeaderModule { }
