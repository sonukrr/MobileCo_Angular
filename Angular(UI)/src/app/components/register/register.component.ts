import { Component, OnInit } from '@angular/core';
import { Customer } from '../../models/customer';
import { CustomerService } from '../../services/customer.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
declare var require: any;

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private _service: CustomerService, private router: Router) { }
  customer: Customer = new Customer();
  data: any;
  districtList: any = [];

  ngOnInit() {
    localStorage.clear();

    //getting all state and district data from JSON file
    this.data = require('../../json/address.json');

  }

  //On clicking the submit button, customer should get registered
  onSubmit(): any {
    this._service.registerCustomer(this.customer).subscribe(
      (res) => {

      }, (error: HttpErrorResponse) => {

        if (error instanceof Error) {
          console.log("Client side error" + error);
        }

        else {
          localStorage.setItem("customer", JSON.stringify(this.customer));
          alert("Employee has been registered successfully");
          alert("Click on Login button");

          console.log("server side error" + error);
          alert(JSON.stringify(this.customer));
          this.router.navigate(['/navbar']);
        }

      }
    );
  }

 //fetching districts only after state is selected
  getdistricts(stateName) {
    console.log(this.districtList);
    // alert(this.customer.address.state);
    this.data.states.forEach(element => {

      console.log(stateName);
      console.log(element.state);
      if (stateName == element.state) {

        this.districtList = element.districts;

      }

    });

  }

}
