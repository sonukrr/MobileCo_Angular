import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CartResponseModel } from '../models/cart-response-model';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private _http:HttpClient) { }

  placeOrders(cartresponse):any{
    return this._http.post("http://localhost:9090/placeorder",cartresponse);

  }

  allOrders(id):any{
    return this._http.get("http://localhost:9090//orders/all/"+id);

  }
}
