import { Component } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../models/Student';

@Component({
  selector: 'app-students',
  standalone: true,
  imports: [],
  templateUrl: './students.component.html',
  styleUrl: './students.component.css',
})
export class StudentsComponent {
  students!: Student[];
  constructor(private studentsService: StudentService) {}

  ngOnInit(): void {
    this.studentsService.getstudents().subscribe({
      next: (data) => {
        console.log(data);
        this.students = data;
        console.log(this.students);
      },
    });
  }
  Deletestudent(id: any) {
    this.studentsService.delete(id).subscribe({
      next: (data) => {
        this.studentsService.getstudents().subscribe({
          next: (data) => {
            console.log(data);
            this.students = data;
          },
        });
      },
    });
  }
}
