# 6.5 Spreading: explanation

**This is breadth-first search from many starting points at once (multi-source BFS).**

**Simple way:** simulate the whole grid minute by minute. Each minute costs O(rows × cols), and there can be O(rows × cols) minutes.

**Better:** a queue that starts with **all** sick cells. Each ring of the BFS is one minute; each healthy cell is reached
exactly when the disease reaches it in the simulation, because BFS finds the shortest distance from the **nearest** start.

**Why it is correct:** the minute a cell turns sick equals its shortest distance to any initially sick cell. A multi-source BFS
computes exactly that distance (it behaves like BFS from a single imaginary node joined to every start).

**Cost:** each cell is queued at most once: **O(rows × cols) time and space.**
