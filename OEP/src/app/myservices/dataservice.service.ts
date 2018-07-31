import {HttpClient} from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()  
export class DataService{

    //SLoginUrl="slogin";
    //ng build 
    SLoginUrl="slogin";
    CourseURL="course";
    ScheduleURL="schedule";
    validateStdURL="login";
    EmpUrl="TeachersServlet";
    Empurl1="schedule";
    validateTeacherURL="tlog";
    EUrl="StudentServlet";
    courseUrl = 'course';
    streamUrl = 'stream';

    loggedInStudent = null;
    loggedInTeacher = null;

    public addNewTeacher(teacher) {
        return this.http.post(this.EmpUrl,JSON.stringify(teacher));
    
    }
    public getAllTeacher(){
        console.log("wow");
        return this.http.get(this.EmpUrl);
    }
    public updateTeacher(teach){
        return this.http.put(this.EmpUrl,JSON.stringify(teach));

    }
    public getAllSchedule(){
       return this.http.get(this.Empurl1);  
    }    constructor(public http : HttpClient) {     
    }
    public addNewLogin(sl) {
        return this.http.post(this.SLoginUrl,JSON.stringify(sl));
    }
    public addNewCourse(sl) {
        return this.http.post(this.CourseURL,JSON.stringify(sl));
    }
    public getAllCourses(){
        return this.http.get(this.CourseURL);
    }
    public getAllLogins(){
        return this.http.get(this.SLoginUrl);
    }
    public addNewSchedule(s1){
        return this.http.post(this.ScheduleURL,JSON.stringify(s1));
    }
    public getSemester(cid){
        return this.http.get(this.ScheduleURL+'?cid='+cid)
     }
     public deleteLogin(user){
        return this.http.delete(this.SLoginUrl,user);
     }
     public regStudent(stud) {
        return this.http.post(this.EUrl,JSON.stringify(stud));
    }
    public loggingService(msg){
        console.log(msg);
    }
    public getStreams(cid){
       return this.http.get(this.streamUrl+'?cid='+cid)
    }
    public getAllStudent(){
        console.log("getting empls")
        return this.http.get(this.EUrl);
    }
    public updateStudent(stud){
        return this.http.put(this.EUrl, JSON.stringify(stud))
    }
     public checkLogin(logindetails) {
        // write code to request server
      this.http.post(this.validateStdURL, JSON.stringify(logindetails))
                    .subscribe(
                        (response) => {
                           this.loggedInStudent = response;
                        }
                    );
        if (this.loggedInStudent != null) {
                return 1;
        } else {
            return -1;
        }
    }
    public checkTLogin(logindetails) {
        // write code to request server
      this.http.post(this.validateTeacherURL, JSON.stringify(logindetails))
                    .subscribe(
                        (response) => {
                           this.loggedInTeacher = response;
                        }
                    );
        if (this.loggedInTeacher != null) {
                return 1;
        } else {
            return -1;
        }
    }

}

