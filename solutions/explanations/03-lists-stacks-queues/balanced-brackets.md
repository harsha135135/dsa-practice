# 3.3 Balanced brackets: explanation

**Why a stack:** a closing bracket must match the **most recent** still-open bracket. "Most recent first" is exactly
what a stack gives.

**Why it is correct:** the stack always holds the open brackets in the order they were opened, waiting to be closed.
A closer is valid only if it matches the top. At the end, anything left on the stack was never closed.
Counting brackets alone fails on `([)]` and `())(`, which is why order matters.

**Cost:** **O(n) time, O(n) space** in the worst case (all openers).

**Use `ArrayDeque`, not `Stack`:** `java.util.Stack` is an old, synchronized class; `ArrayDeque` is the recommended stack.
