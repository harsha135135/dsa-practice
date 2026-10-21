# Deadlock

A **deadlock** is when two or more workers each wait for something another one holds, so none can
ever continue.

```
Thread 1: holds lock A, waits for lock B
Thread 2: holds lock B, waits for lock A      → both wait forever
```

**Four conditions must all hold** (remove any one and deadlock cannot happen):
1. **Mutual exclusion:** a lock can be held by one worker at a time.
2. **Hold and wait:** a worker holds one lock while waiting for another.
3. **No pre-emption:** a lock cannot be taken away; it is only released voluntarily.
4. **Circular wait:** there is a cycle of workers each waiting on the next.

**Usual cure:** always take locks in the **same global order** (for example, by seat number). Then a
cycle is impossible, which breaks condition 4. Timeouts are a safety net.

**Databases:** PostgreSQL detects deadlocks between transactions, cancels one of them with an error,
and lets the other continue. The application should retry the cancelled one.

**Where you see it:** seat-reservation B3 locks exactly **one** seat row per transaction, so two
reservations can never wait on each other in a cycle.

## Self-check

1. Transaction X locks seat 1 then seat 2; Y locks seat 2 then seat 1. What can happen, and how do you fix it?
2. Which of the four conditions does "lock seats in increasing order" remove?
3. What does PostgreSQL do when it finds a deadlock?

<details><summary>Answers</summary>

1. Each may hold its first seat and wait for the other's: deadlock. Fix: both lock in increasing seat order.
2. Circular wait.
3. It aborts one transaction with a deadlock error; the other proceeds. The application can retry.
</details>
