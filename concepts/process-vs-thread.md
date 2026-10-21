# Process vs thread

**A process** is a running program with its **own** memory. Two processes cannot read each other's
memory by accident. Starting `java -jar app.jar` twice gives two processes.

**A thread** is one path of execution **inside** a process. All threads of a process **share** its
memory (the heap), but each thread has its own stack (its own chain of method calls).

| | Process | Thread |
|---|---|---|
| Memory | its own | shared with the other threads of its process |
| Cost to start | higher (new memory space) | lower |
| If it crashes | other processes are unaffected | it can bring down the whole process |
| Talking to others | pipes, sockets, files | just read and write shared objects (carefully!) |

**Why sharing is dangerous:** two threads that both do `count = count + 1` can each read 5 and both
write 6. One update is lost. This is a **race condition**. Locks, `synchronized` or atomic classes prevent it.

**Where you see it:** the HTTP server runs one process with a pool of worker threads. On Linux,
`ps -eLf` lists threads, and `/proc/<pid>/task/` has one folder per thread.

## Self-check

1. Two threads in one JVM change the same `ArrayList`. Is that a problem? Why?
2. Why might a web server use threads instead of starting a new process per request?
3. What does each thread need that it cannot share?

<details><summary>Answers</summary>

1. Yes. `ArrayList` is not thread-safe; both threads see the same object, so updates can be lost or the list corrupted.
2. Threads are cheaper to create and can share data (caches, connection pools) directly.
3. Its own stack (local variables and the chain of calls) and its own position in the code.
</details>
