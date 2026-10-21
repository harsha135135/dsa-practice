# 3.5 Next warmer day (do this at least a week later)

**Write it in:** `src/main/java/practice/lists/WarmerDay.java` · **Test:** `./mvnw test -Dtest=WarmerDayTest`

Try it **without looking at the other exercises first**. Recognising which idea fits is part of the practice.

## Problem

For each day, find how many days you must wait until a **strictly warmer** day. If no warmer day comes,
the answer for that day is `0`.

## Examples

| temperatures | answer |
|---|---|
| `[73, 74, 75, 71, 69, 72, 76, 73]` | `[1, 1, 4, 2, 1, 1, 0, 0]` |
| `[30, 40, 50, 60]` | `[1, 1, 1, 0]` |
| `[30, 30, 30]` | `[0, 0, 0]` |

## Limits

Up to 200,000 days. Looking ahead from every day is O(n²) on a long cooling spell.

## Hints

<details><summary>Hint 1: a nudge</summary>

When a warm day arrives, it answers the question for possibly **many** earlier days at once. Which ones?
</details>

<details><summary>Hint 2: the approach</summary>

Keep the days that are still waiting. Their temperatures never go up from oldest to newest. Why not?
</details>

<details><summary>Hint 3: almost the answer</summary>

A stack of day indexes. For each `today`: while the top day is colder than today, pop it and set its answer to `today - day`. Then push `today`.
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/03-lists-stacks-queues/warmer-day.md`.
