import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private _http:HttpClient) { }

  getAllMobiles():any{
    return this._http.get("http://localhost:9090/items/mobile");

  }

  getAllAccessories():any{
    return this._http.get("http://localhost:9090/items/acc");

  }

  searchResults(text):any{
    return this._http.get("http://localhost:9090/items/"+text);

  }
}
