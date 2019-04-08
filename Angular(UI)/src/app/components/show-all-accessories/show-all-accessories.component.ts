import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';
import { Product } from '../../models/product';
import { HttpErrorResponse } from '@angular/common/http';
import { CartService } from '../../services/cart.service';
import { Cart } from '../../models/cart';
import { Customer } from '../../models/customer';
import { AppComponent } from '../../app.component';

@Component({
    selector: 'app-show-all-accessories',
    templateUrl: './show-all-accessories.component.html',
    styleUrls: ['./show-all-accessories.component.css']
})
export class ShowAllAccessoriesComponent implements OnInit {

    constructor(private appComp: AppComponent, private _service: ProductService, private router: Router, private _cartservice: CartService) { }
    AccessoriesProduct: Array<Product>;
    cart: Cart = new Cart(new Customer(), new Product(), 0);
    ngOnInit() {

        this._service.getAllAccessories().subscribe(
            (res) => {
                this.AccessoriesProduct = res;
                //  alert(JSON.stringify(this.mobileProduct));
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
