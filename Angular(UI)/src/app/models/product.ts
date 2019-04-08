import { Accessories } from './accessories';
import { Mobile } from './mobile';
import { Brand } from './brand';

export class Product {

    public  id;
	public  accessories:Accessories;
	public  mobile:Mobile;
	public  brand:Brand;
	public  price:any;
    public  quantity:number;
    
    constructor(){
        this.id=0;
        this.accessories=new Accessories();
        this.mobile=new Mobile();
        this.brand=new Brand();
        this.price=0;
        this.quantity=0;
    }
}
