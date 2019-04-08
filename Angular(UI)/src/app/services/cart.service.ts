import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cart } from '../models/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private _http:HttpClient) { }

  addToCart(cart:Cart):any{

    return this._http.post("http://localhost:9090/addtocart",cart);

  }

  getItemsInCart(id:number):any{

    return this._http.get("http://localhost:9090/cartitems/"+id);

  }
  updateCartQuantity(cart:Cart):any{

    return this._http.post("http://localhost:9090/updatecart",cart);

  }

  removeFromCart(cart:Cart):any{

    return this._http.post("http://localhost:9090/removecartitem",cart);

  }





}
