import { EmpService } from './emp.service';

import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
 
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  counter: number = 0;
  form: any;
  userProfileForm!: FormGroup;
   

  Dept = [{
    "id"!:0,
    "name":''
  }]

  constructor(private fb: FormBuilder,private emp:EmpService) {

  }


  ngOnInit(): void {

    this.userProfileForm = this.fb.group({
      department: this.fb.group({

        name: [null, [Validators.required, Validators.minLength(4)]],
        employees: this.fb.array([
          this.createItem()
        ])

      })
    })
this.emp.getDeptList().subscribe(data=>{
  console.log(data[0].name)
  this.Dept=data
  console.log(this.Dept) 

})



  }
  createItem(): FormGroup {
    return this.fb.group({
      id: ['', Validators.required],
      name: [null, [Validators.required, Validators.minLength(4)]],
      email: ['', Validators.required],
      address: ['', Validators.required]
    });
  }



  get firstName() {
    return this.department.get('name')
  }

  get getid() {
    return this.department.get(['employees', 'id'])
    //this.userProfileForm.get('department.employees.id')
  }

  get employees() {
    //  return this.userProfileForm.get('department.employees') as FormArray;
    return this.department.get('employees') as FormArray;
  }

  get department() {
    return this.userProfileForm.controls['department'];
  }

  onSubmit() {


    this.emp.createDeptList(this.userProfileForm.value).subscribe(data=>{
      console.log(data);
    })
    //this.employees.push(this.createItem());
    this.form = this.userProfileForm.value
    console.log(this.form)

    // let reqJson = {
    //   "department": this.userProfileForm.value
    // }

  }
  

}
