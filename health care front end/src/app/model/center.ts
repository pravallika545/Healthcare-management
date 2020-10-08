export class Center{
  centerId:number;
  centerName:string;

    constructor(centerId:number,centerName:string){
      this.centerId = centerId;
      this.centerName =centerName;

       
    }

    getcenterName():string{
        return this.centerName;
      }

      
    
}