export class Appointment{
    appointmentId:number;
	 userId:string;
     testId:number;
     dateTime:string;
     approved:boolean;
     centerId:string;
     
     constructor(appointmentId:number,userId:string,testId:number,dateTime:string,approved:boolean,centerId:string){
         this.appointmentId=appointmentId;
         this.userId=userId;
         this.testId= testId;
         this.dateTime=dateTime;
         this.approved=approved;
         this.centerId=centerId;
     }
}