import { Component, OnInit } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from '../../models/cart';
import { OrdersService } from '../../services/orders.service';
import { CartResponseModel } from '../../models/cart-response-model';
import { AppComponent } from '../../app.component';
import { Customer } from '../../models/customer';
import { CustomerService } from '../../services/customer.service';
declare var require: any;
@Component({
    selector: 'app-cart-items',
    templateUrl: './cart-items.component.html',
    styleUrls: ['./cart-items.component.css']
})
export class CartItemsComponent implements OnInit {

    constructor(private _custService: CustomerService, private appComp: AppComponent, private _cartservice: CartService, private route: ActivatedRoute, private router: Router, private _ordersservice: OrdersService) { }
  
    id: any;
    cartList: Array<Cart>;
    updateCart: Cart;
    cartresponsemodel: CartResponseModel;
    OrdersList: any;
    cartOrOrders: boolean = false;
    loggedInUser: Customer;
    updateAddressBlock: boolean = false;
    custWithUpdatedAddress: Customer = new Customer();
    data: any;
    districtList: any = [];
    cust: Customer;
   
    ngOnInit() {
        this.data = require('../../json/address.json');
        this.id = this.route.snapshot.paramMap.get('id');
        this._cartservice.getItemsInCart(this.id).subscribe(
            (res) => {

                this.cartList = res;
              
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

 //check whether product is from mobile or accessories category
    checkType(cartItem) {
        if (cartItem.product.mobile != null) {

            return true;
        }
        else {
            return false;
        }
    }

    //to update quantity of product
    updateQuantity(quantity: number, productId: number) {
        this.cartList.forEach(element => {
            element.customer = JSON.parse(localStorage.getItem('loggedInUser'));
            if (element.product.id == productId) {
                element.orderQuantity = quantity;
                this.updateCart = element;
            }
        });

        this._cartservice.updateCartQuantity(this.updateCart).subscribe(
            (res) => {

                alert(res.error);


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

    //remove product from cart
    removeCartItem(cart: Cart) {

        cart.customer = JSON.parse(localStorage.getItem('loggedInUser'));
        this._cartservice.removeFromCart(cart).subscribe(
            (res) => {
                this.appComp.count--;
                alert(res.error);


                this._cartservice.getItemsInCart(this.id).subscribe(
                    (res) => {

                        this.cartList = res;
                        console.log(this.cartList);



                    }, (error: HttpErrorResponse) => {

                        if (error instanceof Error) {
                            console.log("Client side error" + error);
                        }

                        else {
                            console.log("server side error" + error);
                        }

                    }
                );

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

    //place order successfully
    placeOrder() {
        this.cartList.forEach(element => {
            element.customer = JSON.parse(localStorage.getItem('loggedInUser'));
        });

        this._ordersservice.placeOrders(this.cartList).subscribe(
            (res) => {

                alert(res.error);
                this.appComp.count = 0;
                this.router.navigate(['/navbar']);

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

    //fetch all orders
    allOrders() {
        this._ordersservice.allOrders(JSON.parse(localStorage.getItem('loggedInUser')).id).subscribe(
            (res) => {


                console.log(res);
                this.OrdersList = res;
                this.cartOrOrders = true;


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

    //check whether address of logged in customer exists or not
    addressCheck(): boolean {
        if (JSON.parse(localStorage.getItem('loggedInUser')).address != null) {
            this.loggedInUser = JSON.parse(localStorage.getItem('loggedInUser'));
            return true;
        }
        else return false;
    }

    //update address if exists
    updateAddress() {
        this.updateAddressBlock = true;
    }

    //get list od districts under the selected state
    getdistricts(stateName) {
        this.data.states.forEach(element => {

            console.log(stateName);
            console.log(element.state);
            if (stateName == element.state) {

                this.districtList = element.districts;

            }

        });

    }

    //to update address
    updateAddressNow() {

        this.custWithUpdatedAddress.address.id = JSON.parse(localStorage.getItem('loggedInUser')).address.id;

        this._custService.updateAddress(this.custWithUpdatedAddress).subscribe(
            (res) => {
                alert("Successfully Updated address");
            }, (error: HttpErrorResponse) => {

                if (error instanceof Error) {
                    console.log("Client side error" + error);
                }

                else {
                    console.log("server side error" + error);
                }

            }
        );
        this.cust = JSON.parse(localStorage.getItem('loggedInUser'));

        this.cust.address = this.custWithUpdatedAddress.address;

        //updating local storage with address
        localStorage.clear();
        localStorage.setItem('loggedInUser', JSON.stringify(this.cust));
        this.updateAddressBlock = false;


    }


}
