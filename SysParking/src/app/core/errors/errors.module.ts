import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ContentNotFoundComponent } from './content-not-found/content-not-found.component';


@NgModule({
  declarations: [
    PageNotFoundComponent,
    ContentNotFoundComponent
  ],
  imports: [
    CommonModule
  ],
})
export class ErrorsModule {

}
