import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';
import { Product } from '../../models/product';
import { Cart } from '../../models/cart';
import { Customer } from '../../models/customer';
import { CartService } from '../../services/cart.service';
import { AppComponent } from '../../app.component';

@Component({
    selector: 'app-show-all-mobiles',
    templateUrl: './show-all-mobiles.component.html',
    styleUrls: ['./show-all-mobiles.component.css']
})
export class ShowAllMobilesComponent implements OnInit {

    constructor(private _service: ProductService, private router: Router, private _cartservice: CartService, private appComp: AppComponent) { }
    mobileProduct: Array<Product> = [];
    cart: Cart = new Cart(new Customer(), new Product(), 0);
    ngOnInit() {

        this._service.getAllMobiles().subscribe(
            (res) => {
                this.mobileProduct = res;
                //  alert(JSON.stringify(this.mobileProduct));
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
    }

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
                        this.appComp.count++;
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
