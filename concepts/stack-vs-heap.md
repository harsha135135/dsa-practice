# Stack vs heap

**Stack:** each thread has one. Every method call pushes a **frame** holding its parameters and local
variables; returning pops it. It is fast and automatic, but small (often 512 KiB to 1 MiB per thread).

**Heap:** shared by all threads. Every `new` object lives here. It is big (set with `-Xmx`) and is
cleaned up by the **garbage collector** when nothing refers to an object any more.

```java
void example() {
    int count = 3;                     // the int lives in this frame, on the stack
    List<String> names = new ArrayList<>(); // the reference is on the stack; the ArrayList object is on the heap
}
```

| | Stack | Heap |
|---|---|---|
| Holds | frames: local variables, parameters | objects |
| Freed | when the method returns | by the garbage collector |
| Shared between threads | no | yes |
| Error when full | `StackOverflowError` | `OutOfMemoryError` |

**Where you see it:** a recursive flood fill on a million-cell island can throw `StackOverflowError`
(see dsa-practice exercise 6.2); switching to an `ArrayDeque` moves the work to the heap.

## Self-check

1. A method makes a local `int[] big = new int[1_000_000]`. Where is the array stored?
2. Why does deep recursion fail but a loop with an explicit stack does not?
3. Can two threads see the same local variable?

<details><summary>Answers</summary>

1. On the heap. Only the reference `big` is in the stack frame.
2. Each recursive call adds a frame to the small thread stack; an `ArrayDeque` grows on the much larger heap.
3. No. Locals live in the thread's own frames (but an object they point to can be shared).
</details>
