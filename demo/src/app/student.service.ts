import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from './models/Student';
const URL = 'http://localhost:8080/api';
@Injectable({
  providedIn: 'root',
})
export class StudentService {
  constructor(private http: HttpClient) {}
  public getstudents(): Observable<Student[]> {
    return this.http.get<Student[]>(URL);
  }
  public Createstudent(lastname: any, firstname: any, email: any) {
    return this.http.post(URL, { lastname, firstname, email });
  }
  delete(id: any) {
    return this.http.delete(URL + `/${id}`);
  }
}
