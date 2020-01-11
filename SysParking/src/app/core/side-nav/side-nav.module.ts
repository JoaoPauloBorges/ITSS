import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarModule } from 'primeng/sidebar';
import {ButtonModule} from 'primeng/button';
import { SideNavComponent } from './side-nav.component';



@NgModule({
  declarations: [
    SideNavComponent
  ],
  imports: [
    CommonModule,
    SidebarModule,
    ButtonModule
  ],
  exports: [SideNavComponent]
})
export class SideNavModule { }
