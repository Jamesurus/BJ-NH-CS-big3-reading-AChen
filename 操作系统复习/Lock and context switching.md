# synchronization

mechanism to ensure multiple concurrent processes or threads don't execute some program at the same time, but to execute in order.

```java
public class Bank_account   
     { 
       private int bal = 0;
       public void    
       Bank_account(int start_balance) 
          { bal = start_balance; } 
        public void update(int amount)  
            { bal = bal + amount; }
      } 
... 
Bank_account b = new Bank_account(0);
```

2 processes: b.update(5), But final result still 5, because these 2 processes are racing

# critical section

code segment that accesses a shared value/ resource

# mutual exclusion

only one thread can run within the critical section at any given time

# Atomic

a context can't happen while an atomic section of code is being execuetd

# ==how to achieve synchronization?==

1. lock: acquire(),release()
2. monitors
3. semaphores
4. message-distributed system

Locks comprises two states:

held: a thread is executing the critical section

not held: no thread is executing the critical section

用Lock声明锁

```java
public class Bank_account {
    private int bal = 0;
    public void Bank_account(int start_balance)   
         { bal = start_balance; }
    public void synchronized update(int amount)  
         { bal = balance + amount; }
}
```

synchronized可修饰方法或者代码块,加在方法类型后面,名字前面

或者加在代码块

# context switching

store context for a thread so that when it come back it can resume exactly where it left