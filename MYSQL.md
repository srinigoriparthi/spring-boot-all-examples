MYSQL INFORMATION
=================
1.Download My SQL Community Server 8.0.18.  
    https://dev.mysql.com/downloads/mysql/    
2.Download My SQL Work Bench 8.0.18.   
    https://dev.mysql.com/downloads/workbench/  
3.Download My SQL Shell 8.0.18.  
    https://dev.mysql.com/downloads/shell/
 
 **Commands to start My SQL Community Server:**  
 1. Set My SQL Home and Path in User Env variables.  
    - MYSQL_HOME = D:\DEVWORK\DEVSOFTS\mysql-8.0.18-winx64    
    - PATH = D:\DEVWORK\DEVSOFTS\mysql-8.0.18-winx64\bin  
 
 **Very first time after My SQL installation setup the below only one time.**  
 - Create "data" directory in MYSQL installaiton folder like D:\DEVWORK\DEVSOFTS\mysql-8.0.18-winx64\data.      
 - Go to command prompt and execute the below commands.  
- cmd> mysqld --console --initialize --basedir=D:\DEVWORK\DEVSOFTS\mysql-8.0.18-winx64  
    
**Note:**
- The above --initialize step should be execute only one time after Software installation.  
- In the above step it will generate the Temp passcode and note down to change the samem in next step.  

**Starts MySQL Server:**
- cmd> mysqld --console

**Open another cmd prompt and Start MySQL Shell:**  
- cmd> mysql.exe -u root -p  
- mysql> alter user 'root'@'localhost' identified by 'password';  
- mysql> show databases;

**Shutdown MySQL Server:**  
- cmd> mysqladmin -u root -p shutdown 

**Create user Table in MySql DB**  

create table persondb.user  
(  
      id int not null  primary key,  
      password varchar(45) not null,  
      active varchar(45) null,  
      roles varchar(45) not null,  
      user_name varchar(255) null  
  );  
 


  
 