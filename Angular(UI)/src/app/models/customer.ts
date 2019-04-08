import { Address } from './address';

export class Customer {


    public  id:number;
	public name:string;
	public  email:string;
	public  phone:string;
	public  password:string;
    public address:Address ;
    
    constructor(){
        this.id=0;
        this.name="";
        this.email="";
        this.phone="";
        this.password="";
        this.address=new Address();
        
    }
}
