import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { Product } from '../../models/product';
import { HttpErrorResponse } from '@angular/common/http';
import { CartService } from '../../services/cart.service';
import { Cart } from '../../models/cart';
import { Customer } from '../../models/customer';
import { AppComponent } from '../../app.component';


@Component({
    selector: 'app-search',
    templateUrl: './search.component.html',
    styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

    constructor(private appComp: AppComponent, private route: ActivatedRoute, private _service: ProductService, private _cartservice: CartService) { }

    text: any;
    searchResult: Array<Product>;
    cart: Cart = new Cart(new Customer(), new Product(), 0);
    ngOnInit() {
        this.text = this.route.snapshot.paramMap.get('text');


        this._service.searchResults(this.text).subscribe(
            (res) => {
                this.searchResult = res;

                console.log(this.searchResult);



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

    checkType(product: Product) {
        if (product.mobile != null)
            return true;
        else return false;

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
