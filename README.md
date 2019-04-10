# attendance-project
   Spring-boot-security authentication&amp; authorization db register attendance  signin signout
   
# Technologies
          Spring-security
          Spring-boot (JPA)
          Mvc Pattern
          HTML5,CSS3 (thymeleaf)
          Custom error Pages
          keystore (jks)
# EndPoints:
         https://localhost:3000/register              -----------> for register
         https://localhost:3000/secured/loginUser             --->  User Login
         https://localhost:3000/secured/loginAdmin            ---> Admin Login
         https://localhost:3000/secured/attendancSignIn       ---> Attendance signIn
         https://localhost:3000/secured/attendancSignOut      ---> Attendance signOut
         https://localhost:3000/secured/getList            -----> get remoteUser AttendanceDetails        
# Prior:
         change application.properties 
         spring.jpa.hibernate.ddl-auto=cteate
         and again change into 
         spring.jpa.hibernate.ddl-auto=update
# Project Domain 

       If the working hours goes below 8 Hrs, but greater than 4 Hrs, half day absent is marked. 
       If the Hours goes below 4 Hrs, full day absent is marked. 
       if fail to attendanceSignOut,  attendanceSignIn will not work so mandatory to attendanceSignOut 
       GetList menu  get remoteUser AttendanceDetails 
           
           
         
