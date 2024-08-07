# ********** @Schedule  Cron jobs in spring boot 
three types of scheduling 
1. Fixed rate 
2. Fixed Delay 
3. Cron : most important job 


# --- Need to describe the configuration class with @EnableScheduling annotation and @Configuration annotation  this config class can be empty 

sytax: @Configuration 
       @EnableScheduling
       public class Class_Name(SchedulingConfig:usually){

       }
 
# --- add @Component class with Logs and other tasks to perform make sure access modifiers are public and return types are void if not it will just skip the results 

syntax: 
       @Component
       public class FixedRate_Class{
          @Scheduled(fixedRate=5000){
              task stmts;
          }
       }

# --- for corn jobs we have to annotate the methods from component class with @Scheduled annotation this annotation takes the argument like the bash cron syntax need to specify into "" colons 

like : @Scheduled(cron ="*/5 * * * *")
       public void task(){
           stmts;
       }


# syntax for cron string :
  0*/2***
  0= Second (0th second of the minute)
  */2 =Minutes (Every two minutes)
  * = Hours (Every hour)
  * = Day of Month (Every Day of the month)
  * = month (Every month)
  ? = Day of the week  (any day of the week) 
