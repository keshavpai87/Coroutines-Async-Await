# Async and Await
Let’s assume we have to get the result from four online data sources and combine them all to show the final result to the user.. 
Suppose T1 => 10s, T2 => 15s, T3 => 12s, T4 => 13s. Altogether it takes 50s to complete and get the result which is a long wait and a bad experience to the user. 
To complete this at the earliest, we need to run all the taks in parallel and we can complete them in 15s. Writing the codes to complete the task and combining them all together is called 
parallel decomposition and this can be achieved using **Async and Await** functions.

To understand this, lets create a new Android studio project and add coroutines dependencies to the gradle. For this lesson, let’s just assume we have two remote stores. We need to get the 
stock count from both of them using different URLs and show the final stock count to the user.

![image](https://github.com/user-attachments/assets/abf12e1e-b051-456f-b271-97dfbd034427)

Here we have defined 2 methods, with delay of 10 secs and 8secs, to get the stocks of 2 different stores, also logging them when the method is triggered and then finally we are calculating the total value from it. On Execution, we can see that it took total of 18secs to execute and calculate the total and display it

![image](https://github.com/user-attachments/assets/ff090e40-bba3-4903-9370-509787ffee27)

Now if we make the changes to the code to make use of async and await, the code will look as below

![image](https://github.com/user-attachments/assets/426c8501-9141-4055-8d52-2ab11e1b5889)

Lets run it. We can see that the time consumed for T1 is 8secs and T2 is 10 secs. The total process finished in 10secs to calculate the total and display it as shown below

![image](https://github.com/user-attachments/assets/0101e6d9-8ef0-4b07-97b9-0d24cc9d8508)

This is called parallel decomposition which we implemented using async builder and await function call. Here we launched a coroutine in a background thread belong to IO thread pool and did all parallel executions here. But we have other options also. We can also provide dispatchers for parallel tasks. Let me show you with a code example.

![image](https://github.com/user-attachments/assets/e0c33bdf-c8a9-412a-8788-2e78f68cd3b6)

Here, the dispatcher is changed from IO to Main. After that I have provided dispatchers.IO context for each of the aysnc blocks. Now, these parallel events will happen in the background.
Since this code block executes in the main thread, we have added a toast message here to show the total value. No change in the time consumed but the result is displayed on the UI in the form of toast as shown below

![image](https://github.com/user-attachments/assets/f73d190a-a1de-43bb-a628-e3a9f01f9b84)

So this is how we implement concurrency with coroutines. This is how we use async and await to get data from different data sources parallely and combine the results.
