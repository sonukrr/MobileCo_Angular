import { Component, OnInit } from '@angular/core';
import { Customer } from '../../models/customer';
import { Router } from '@angular/router';
import { CustomerService } from '../../services/customer.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private _service: CustomerService) { }
  cust: Customer = new Customer();
  ngOnInit() {
    localStorage.clear();

  }

  //on submit button
  onSubmit(): any {

  //to authenticate customer credentials
    this._service.loginUserCheck(this.cust).subscribe(
      (res) => {
        if (res.id != 0) {
          res.password = this.cust.password;
          alert("Employee has been logged in successfully with EmpId :" + res.id);

          localStorage.setItem("loggedInUser", JSON.stringify(res));
          this.router.navigate(['/navbar']);

        }
        else {
          alert("Please login with correct credentials");
        }
      }, (error: HttpErrorResponse) => {

        if (error instanceof Error) {
          console.log("Client side error" + error);
        }

        else {
          console.log("server side error" + error);
        }

      }
    );

  }
}
