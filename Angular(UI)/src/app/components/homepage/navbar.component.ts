import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Product } from '../../models/product';
import { Router } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { Cart } from '../../models/cart';
import { Customer } from '../../models/customer';
import { AppComponent } from '../../app.component';

declare var require: any;
@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
    constructor(private _service: ProductService,
        private router: Router, private _cartservice: CartService,
        private appComp: AppComponent) { }

    mobileProduct: Array<Product> = [];
    AccessoriesProduct: Array<Product>;
    cart: Cart = new Cart(new Customer(), new Product(), 0);
    cartList: Array<Cart>;
    //  count:number=0;

    ngOnInit() {
        //get list of all mobiles
        this._service.getAllMobiles().subscribe(
            (res) => {
                this.mobileProduct = res;
                console.log(this.mobileProduct);
            }, (error: HttpErrorResponse) => {

                if (error instanceof Error) {
                    console.log("Client side error" + error);
                }

                else {
                    console.log("server side error" + error);
                }

            }
        );
    //get list of all accessories
        this._service.getAllAccessories().subscribe(
            (res) => {
                this.AccessoriesProduct = res;
                console.log(this.AccessoriesProduct);
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
//update image from product ID
    updateImage(id: string) {
        var link = require("../../images/" + id + ".jpg");
        //  alert("--->"+link);
        return link;
    }

//add product to cart
    addToCart(product: Product) {

        if (localStorage.getItem("loggedInUser") == null) {
            alert("<------Please Login or register first to add to cart------->");
        }
        else {
            this.cart.product = product;
            this.cart.customer = JSON.parse(localStorage.getItem('loggedInUser'));
            this.cart.orderQuantity = 1;


            this._cartservice.addToCart(this.cart).subscribe(
                (res) => {

                    alert(res.error);
                    if (res.error === "Item Added to cart :)") {
                        this.appComp.count++;                       //update quantity on template(view)
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



}
