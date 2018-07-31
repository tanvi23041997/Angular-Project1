import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginTComponent } from './login-t/login-t.component';
import {Routes, RouterModule} from '@angular/router';
import { LoginAComponent } from './login-a/login-a.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { ManageLoginComponent } from './manage-login/manage-login.component';
import { ManageCourseComponent } from './manage-course/manage-course.component';
import { ManageExamScheduleComponent } from './manage-exam-schedule/manage-exam-schedule.component';
import { DeleteLoginComponent } from './manage-login/delete-login/delete-login.component';
import { AddLoginComponent } from './manage-login/add-login/add-login.component';
import { DataService } from './myservices/dataservice.service';
import { HttpClientModule} from '@angular/common/http';
import { AddCourseComponent } from './manage-course/add-course/add-course.component';
import { DeleteCourseComponent } from './manage-course/delete-course/delete-course.component';
import { AddScheduleComponent } from './manage-exam-schedule/add-schedule/add-schedule.component';
import { DeleteScheduleComponent } from './manage-exam-schedule/delete-schedule/delete-schedule.component';
import { UpdateScheduleComponent } from './manage-exam-schedule/update-schedule/update-schedule.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { FacultyRegistrationComponent } from './faculty-registration/faculty-registration.component';
import { TeacherHomeComponent } from './teacher-home/teacher-home.component';
import { ExamShedComponent } from './exam-shed/exam-shed.component';
import { EditComponent } from './edit/edit.component';
import { StudentRegistrationComponent } from './student-registration/student-registration.component';



const appRoutes: Routes=[
  {   
    path:'',
    component:LoginComponent
  },
  {
    path:'slogin',
    component:LoginComponent
  },
  {
    path:'tlogin',
    component:LoginTComponent
  },
  {
    path:'freg',
    component:FacultyRegistrationComponent
  },
  {
    path:'thome',
    component:TeacherHomeComponent
  },
  {
    path:'alogin',
    component:LoginAComponent
  },

  {
    path:'home',
    component:StudentHomeComponent
  },
  {
    path:'adminHome',
    component:AdminHomeComponent,
  }, 
  {
    path:'examsched',
    component:ExamShedComponent
  },
  {
    path:'edit',
    component:EditComponent
  },
  {
    path:'register',
    component:StudentRegistrationComponent
  },
  {
    path:'manageLogin',
    component:ManageLoginComponent,
    children:[
      {
        path:'',
        component:AddLoginComponent
      },
      {
        path:'addLogin',
        component:AddLoginComponent
      },
      {
        path:'deleteLogin',
        component:DeleteLoginComponent
      }
    ]
  },
  {
    path:'manageCourse',
    component:ManageCourseComponent,
    children:[
      {
        path:'',
        component:AddCourseComponent
      },
      {
        path:'addCourse',
        component:AddCourseComponent
      },
      {
        path:'deleteCourse',
        component:DeleteCourseComponent
      }
    ]
  },
  {
    path:'manageSchedule',
    component:ManageExamScheduleComponent,
    children:[
      {
        path:'',
        component:AddScheduleComponent
      },
      {
        path:'addExam',
        component:AddScheduleComponent
      },
      {
        path:'deleteExam',
        component:DeleteScheduleComponent
      },
      {
        path:'updateExam',
        component:UpdateScheduleComponent
      }
    ]
  }
  ]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoginTComponent,
    LoginAComponent,
    AdminHomeComponent,
    ManageLoginComponent,
    ManageExamScheduleComponent,
    ManageCourseComponent,
    AddLoginComponent,
    DeleteLoginComponent,
    AddCourseComponent,
    DeleteCourseComponent,
    AddScheduleComponent,
    DeleteScheduleComponent,
    UpdateScheduleComponent,
    StudentHomeComponent,
    FacultyRegistrationComponent,
    TeacherHomeComponent,
    ExamShedComponent,
    EditComponent,
    StudentRegistrationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
