# 3.5 Next warmer day: explanation

**This is a monotonic stack.**

**Simple way:** for each day, scan forward. O(n²).

**Better:** keep a stack of days still waiting for a warmer day. A new day first answers every waiting day that is
colder, popping them, then waits itself.

**Why the stack stays in order:** a day is pushed only after every colder day below it was popped, so temperatures
on the stack never increase from bottom to top. That is why we only ever need to look at the top.

**Why it is correct:** a waiting day is popped at the **first** later day that is warmer, because every day in between
was checked against it while it was on the stack, and none was warmer.

**Cost:** each day is pushed once and popped at most once: **O(n) time**, O(n) space.
