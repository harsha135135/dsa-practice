# 4.4 N queens: explanation

**Reduce the choices first:** one queen per row means we only choose a **column** for each row.

**Fast attack checks:** a queen at (r, c) blocks column c, the diagonal with `r − c` constant, and the diagonal with
`r + c` constant. Three boolean arrays answer "is this cell attacked?" in O(1), instead of checking all queens placed so far.

**Why it is correct:** every complete placement has one queen per row, and the search tries every non-attacked column
in every row, so every valid placement is reached exactly once. Undoing the marks after each try restores the board.

**Cost:** exponential (the answer itself grows fast), but pruning makes it far smaller than nⁿ. O(n) space.

**Even faster:** the three arrays can be replaced by bitmasks (topic 8).
