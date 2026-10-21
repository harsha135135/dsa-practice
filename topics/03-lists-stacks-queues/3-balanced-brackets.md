# 3.3 Balanced brackets (standard)

**Write it in:** `src/main/java/practice/lists/BalancedBrackets.java` · **Test:** `./mvnw test -Dtest=BalancedBracketsTest`

## Problem

Return `true` if every opening bracket `(`, `[`, `{` in the text is closed by the matching bracket,
and brackets close in the right order (the most recently opened one closes first). Ignore all other characters.

## Examples

| text | answer |
|---|---|
| `{[()()]}` | `true` |
| `([)]` | `false`, closed in the wrong order |
| `())(` | `false`, equal counts are not enough |
| `int f(int[] a) { return a[0]; }` | `true` |

## Limits

Up to 200,000 characters, nested very deeply.

## Hints

<details><summary>Hint 1: a nudge</summary>

When you see a closing bracket, which opening bracket must it match?
</details>

<details><summary>Hint 2: the approach</summary>

The most recently opened bracket that is still open. That is last in, first out: a stack.
</details>

<details><summary>Hint 3: almost the answer</summary>

Push openers. For a closer: if the stack is empty or the popped opener does not match, return `false`. At the end, the stack must be empty.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/03-lists-stacks-queues/balanced-brackets.md`.
