import { Routes } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { CreationComponent } from './creation/creation.component';

export const routes: Routes = [
  { path: '', redirectTo: 'students', pathMatch: 'full' },
  { path: 'students', component: StudentsComponent },
  { path: 'creation', component: CreationComponent },
];
