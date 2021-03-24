import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  constructor(private httpClient: HttpClient) { }

  private baseURL = "http://localhost:8080/dept";
  private baseUrl="http://localhost:8080/department"
  getDeptList(): Observable<any>{
    return this.httpClient.get<any>(`${this.baseURL}`);
  }
  createDeptList(department: any): Observable<any> {

    return this.httpClient.post(`${this.baseUrl}`,department)
  
  }
}
