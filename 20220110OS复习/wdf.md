总复习

program and process

# 比较kernel threads and unix process

==kernel thread== is a stack/program combination ==supported by OS==.

Unix process is a "virtual machine"comprises a virtual address and a thread.

Because virtual machine context is regarded as thread context.

# Unix style process-3

1. threads share a common address space.
2. lighter-weight switch
3. support fine-grained concurrency

有可能是process和thread的区别

# Unix kernel  user thread的区别

user threads most useful for structing conceptually concurrent,概念并发,就是并发,干这个的时候不能干那个?

## user thread

1. user threads are supported in user-level library,
2.  kernel only knows process
3. cheaper and faster context switch
4. easy to offer per-application scheduling policy

## Disadvantage of user thread

system call will cause other threads in the same process block

user threads cannot execute on multicore at the same time.

## kernel threads

1. kernel threads are supported by OS scheduler, 
2. preemptable,
3. more concurrent, especially on multicore
4. more predictability useful for real-time applications 

进程都有自己独立的地址空间

线程共享地址空间

# thread in language runtime environments(Java)

1. available only in particular language environment
2. might be implemented either as user or kernel threads

# 操作系统作用

1. manages hardware adn system resources
2. shares out and accounts for resources
3. provide IO system and common device

Hardware abstraction allows us to hide hardware differences from operating system.

嵌入/实时强调

长期可靠,时效保证,小体量代码

Unix 和 NT占据操作系统主要市场

关于用户界面是不是操作系统一直存在争议

DOS: Disk Operating System

backward compatibility-向下兼容

monolithic-单片机

All OS code running with full priviledges.安全性很难有保障

效率高,但不好管理

micro-kernel最少量代码有系统权限,大多数代码在用户空间

# concurrency components-3

1. actor
2. shared resources
3. access rules

## Shared resources

1. memory
2. hardware devices

# Concurrency definition

how ==multiple, independently controlled processes== behave when running and interacting with each other.

Interface similar to abstract class, but don't have initial state

class implement Runnable

建立一个线程类的对象,在线程的构造函数里传入这个对象

3 central concepts in concurrent programming

hardware device

instruction sequence

active system entity

why concurrent?

multicore machine make algorithms run faster to implement OS and network internels

when  there is no need to worry concurrency?

no shared data, read only

process abstract over processors and disturbed sewuential execution.

processors can have multiple processes regardless the number of processors.

no every compute platform supports latest hardware.

Legacy hardware

legacy code

concurrency can be used to improve response time perceived.

# synchronization

mechanism to ensure  multiple concurrent processes or threads do not execute some particular program at the same time, insead, in some particular order.

# Methods

competition

coordination

## critical section

code segment that accesses a shared resource.

# Properties

mutual exclusion, at a time, only one thread in sritical section.

bounded waiting, any thread that wants to be in critical section eventually enter.

performance

fairness

progress, thread outside the critical section cannot stop other threads entering.

# mutual exclusion

only one thread can run in the critical section at any given time.

# Cooperation

manages the order to ensure threads access critical section in some particular order.

# synchronization solutions

## atomicity

mutual exclusion

## mutual exclusion

order thread execution

# build critical section ways-4 

1. locks-primitive
2. monitors-higher level, not all languages support
3. semaphores
4. message-used in distributed systems

Lock comprises two states,

held

not held

operations to move lock between states.

acquire,mark lock as held or wait until release

release, mark as not held

each java object has an implicit lock

synchronized statement to achieve lock

context switch

need to store the information for a switched-out thread so that when it come back, context can resume to the original state.

# A thread's context minimally conclude pc and sp

program counter

stack pointer

上下文切换的三步:

# concurrency management solutions:

competition: mutual excusion

cooperation: conditional synchronization

lock only provide mutual exclusion

==wait(),p()==

==signal(),V()==

each semaphore has an associated queue for processes

implementation in traditional Unix kernel

the implementation builds on 2 lower-level intra-kernel process synchronization primitives.

sleep()

wakeup()

the traditional Unix kernel is non-preemptible, no need for additional mutual exclusion to make wait() and signal() atomic.

semaphores in Java

like the intrinsic lock, each java object has an intrinsic wait queue.

# spurious wakeup

message passing: inter-process communication

processes in other machines cannot read memory address on other machine.

data is sent/ received on channels

MP primitives:

send(msg,chan)

receive(chan)

message passing can be used in shared memory distributed memory

synchronous-require the sender and receiver to wait for each other while transferring message

process calling send() blocked until message is received from channel

asynchronous-they do not wait, 

receive() is blocked until a message is sent to the channel.

some form of bufer is deployed for asychronous message passing

# practical considerations

performance

reliability

buffering

message passing 的并发通过一个服务器进程实现的

支持互斥和条件同步

each java object has intrinsic lock

object.wait()

object.notify()

an alternative is to keep the thread active, and continuously "spin" attempting to acquire the lock

critical section is not accessed atomically.

锁是互斥的,之恶能有一个获取锁

spinlock solutions:

disable interrupts

speciall  machine instruction enuring atomicity

software-only solution





