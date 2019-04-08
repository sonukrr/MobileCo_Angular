import { Cart } from './cart';

export class CartResponseModel {

    public  error:string;
    public results: Array<Cart>;

    constructor(error:string,results:Array<Cart>){
        this.error=error;
        this.results=results;

    }
}
