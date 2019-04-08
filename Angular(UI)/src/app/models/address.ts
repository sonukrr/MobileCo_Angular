export class Address {

    public id:number;
	public street:string;
	public  city:string;
	public  state:string;
	public  country:string;
    public  pincode:number;
    
    constructor(){
        this.id=0;
        this.street="";
        this.city="";
        this.state="";
        this.country="INDIA";
        this.pincode=0;
    }
}
