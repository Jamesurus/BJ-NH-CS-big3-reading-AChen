concurrency components:

1. actors
2. shared resources
3. access rules

thread: smallest sequence of instructions managed by scheduler

scheduler: assign resources to process

# Shared Resource:

1. Memory
2. hardware devices

Interface: no method body

implement an interface must provide an implementation of all method signatures in the interface.

```java
public class MesssagePrinter implements Runnable 
{ 
    String message; 
    public MessagePrinter(String m) { message = m; }	//conctructor
    public void run() 
         { 
            TextArea text = new TextArea(...); 
            appendText(message); 	// The thread’s work is now complete. 
         }
 }
public class startPrinter
    { 
        public static void main (String[] args) 
           { 
            	MessagePrinter mp = new MessagePrinter(“I am thread t"); 
             	Thread t = new Thread(mp); 
             	 t.start(); 
             	 for(int j = 0; j < 1000; j++)  
                 System.out.println("I am main thread");     
             }   
     }
```

# how to create thread in Java?

1. define class R implements Runnable, make an instance of class R
2. pass instance of class R to a thread instance
3. start method(), which causes java immediately execute R.run() as a new thread

# Difference between program and process

program is static instructions while process is dynamically executing program. 

Example, we can open multiple wordpad to edit different works at the same time, wordpad is a program, multiple editions are different processes.



Scheduler decides which process to execute next.

concurrency guarantee no starvation, no guarantee about the fairness and timeliness.

concurrency abstract on processors and disturbed sequential execution.

# process context包括什么?

place in program and stack.

2 key machine registers

PC: program counter

SP: stack pointer