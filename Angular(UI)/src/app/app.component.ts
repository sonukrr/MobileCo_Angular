import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from './models/product';
import { Customer } from './models/customer';
import { Cart } from './models/cart';
import { ProductService } from './services/product.service';
import { CartService } from './services/cart.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private _service: ProductService, private router: Router, private _cartservice: CartService) { }

  cartList: Array<Cart>;
  count: number = 0;
  checkLogin: boolean = true;

  ngOnInit() {
    this._cartservice.getItemsInCart(JSON.parse(localStorage.getItem("loggedInUser")).id).subscribe(
      (res) => {

        this.cartList = res;
        console.log(this.cartList);
        this.count = this.cartList.length;



      }, (error: HttpErrorResponse) => {

        if (error instanceof Error) {
          console.log("Client side error" + error);
        }

        else {
          console.log("server side error" + error);
        }

      }
    );
    this.router.navigate(['\loginpage']);

  }



  controlButtons() {

    if (localStorage.getItem("loggedInUser") != null)
      return false;
    else return true;

  }

  logout() {
    localStorage.removeItem("loggedInUser");
    localStorage.removeItem("customer");
    alert("**You have been successfully lgged out**");
    this.router.navigate(['/navbar']);
  }

  search(text) {
    //   alert(text);
    this.router.navigate(['/search', text]);


  }

  getItemsInCart() {

    this.router.navigate(['/cartItems', JSON.parse(localStorage.getItem("loggedInUser")).id]);

  }

  check_Login() {
    if (JSON.parse(localStorage.getItem("loggedInUser")).id == null) {
      alert("true");
      this.checkLogin = true;
    } else this.checkLogin = false;
  }
}
