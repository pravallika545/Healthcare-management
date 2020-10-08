export class Test{
    id:number;
    name:string;
   centerId:number;
  
    constructor(id:number,name : string,centerId:number){
      this.id=id;
      this.name=name;
    this.centerId=centerId
      
    }
   
    getName():string{
      return this.name;
    }
  
   getCenterId():number{
     return this.centerId;
   }
  
  }