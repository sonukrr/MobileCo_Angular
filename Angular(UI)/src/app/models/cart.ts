import { Customer } from './customer';
import { Product } from './product';

export class Cart {
    public  customer:Customer;
	public  product:Product;
    public orderQuantity:number;
    
    constructor(customer:Customer,product:Product,orderQuantity:number){
        this.customer=customer;
        this.product=product;
        this.orderQuantity=orderQuantity;
    }
}
