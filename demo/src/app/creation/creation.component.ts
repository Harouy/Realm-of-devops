import { Component } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Student } from '../models/Student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-creation',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './creation.component.html',
  styleUrl: './creation.component.css',
})
export class CreationComponent {
  constructor(private studentservice: StudentService, private router: Router) {}
  student = new Student();
  lastname = new FormControl('');
  firtsname = new FormControl('');
  email = new FormControl('');

  Onsubmit() {
    this.studentservice
      .Createstudent(
        this.lastname.value,
        this.firtsname.value,
        this.email.value
      )
      .subscribe({
        next: (data: any) => {
          this.router.navigate(['students']);
        },
      });
  }
}
