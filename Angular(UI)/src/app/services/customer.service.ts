import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private _http:HttpClient) { }

  registerCustomer(cust:Customer):any{
    return this._http.post("http://localhost:9090/signme",cust);

  }
  


  loginUserCheck(cust:Customer):any{
    return this._http.post("http://localhost:9090/loginCustomer",cust);

  }


  updateAddress(cust:Customer):any{
    return this._http.post("http://localhost:9090/updateAddress",cust);

  }
  
}
