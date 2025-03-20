# Async and Await
Let’s assume we have to get the result from four online data sources and combine them all to show the final result to the user.. 
Suppose T1 => 10s, T2 => 15s, T3 => 12s, T4 => 13s. Altogether it takes 50s to complete and get the result which is a long wait and a bad experience to the user. 
To complete this at the earliest, we need to run all the taks in parallel and we can complete them in 15s. Writing the codes to complete the task and combining them all together is called 
parallel decomposition and this can be achieved using **Async and Await** functions.

To understand this, lets create a new Android studio project and add coroutines dependencies to the gradle. For this lesson, let’s just assume we have two remote stores. We need to get the 
stock count from both of them using different URLs and show the final stock count to the user.

![image](https://github.com/user-attachments/assets/abf12e1e-b051-456f-b271-97dfbd034427)

Here we have defined 2 methods to get the stocks of 2 different stores, also logging them when the method is triggered and then finally we are calculating the total value from it. On 
Execution, we can see that it took total of 18secs to execute and calc the total and display it

![image](https://github.com/user-attachments/assets/ff090e40-bba3-4903-9370-509787ffee27)

