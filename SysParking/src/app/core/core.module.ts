import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderModule } from './header/header.module';
import { ErrorsModule } from './errors/errors.module';
import { FooterModule } from './footer/footer.module';
import { SideNavModule } from './side-nav/side-nav.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HeaderModule,
    FooterModule,
    ErrorsModule,
    SideNavModule
  ],
  exports: [
    HeaderModule,
    FooterModule,
    ErrorsModule,
    SideNavModule
  ]
})
export class CoreModule { }
