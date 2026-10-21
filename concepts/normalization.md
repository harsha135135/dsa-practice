# Database normalization

**Normalization** means storing each fact **once**, in the one table where it belongs, so it cannot
disagree with itself.

**A table that is not normalized:**

| reservation_id | user_email | event_title | seat |
|---|---|---|---|
| 1 | alice@x.com | Demo Event | 42 |
| 2 | alice@x.com | Demo Event | 43 |

The event title is repeated. Rename the event and you must update every row; miss one, and the data
disagrees with itself (an **update anomaly**).

**Normalized:** `event(id, title)`, `app_user(id, ...)` and `reservation(id, event_id, user_id, seat)`.
The title lives in exactly one row, and reservations point to it with a **foreign key**.

**The normal forms, in short:**
- **1NF:** each cell holds one value (no lists inside a cell).
- **2NF:** every non-key column depends on the **whole** key, not just part of it.
- **3NF:** non-key columns depend on the key **only**, not on other non-key columns.

**When to break the rule (denormalize):** for read speed, sometimes on purpose, with a plan to keep the copies in sync.

**Where you see it:** seat-reservation B2's schema. Note that availability is **not** stored as a flag; it is
derived from active reservations, because a stored flag would be a second copy of the same fact.

## Self-check

1. Why is a stored `seat.available` column risky in this project?
2. What does a foreign key protect against?
3. A table has `(order_id, product_id, product_name, quantity)` with key `(order_id, product_id)`. Which normal form does it break?

<details><summary>Answers</summary>

1. It repeats a fact already known from active reservations; the two can disagree after a bug or a crash.
2. Rows that point at something that does not exist (for example, a reservation for a missing event).
3. 2NF: `product_name` depends only on `product_id`, which is part of the key.
</details>
