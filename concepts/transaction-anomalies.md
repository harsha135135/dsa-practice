# Transaction anomalies

A **transaction** groups database steps so they succeed or fail together. When many transactions run at
the same time, the **isolation level** decides how much they can see of each other. Weaker isolation is
faster but allows **anomalies**:

| Anomaly | What happens |
|---|---|
| **Dirty read** | You see another transaction's change before it commits; it may roll back. |
| **Non-repeatable read** | You read a row twice and get different values, because someone committed in between. |
| **Phantom read** | You run the same query twice and new rows appear, because someone inserted and committed. |
| **Lost update** | Two transactions read the same value, both change it, and the second write erases the first. |
| **Write skew** | Two transactions each check a rule, both see it is fine, and write different rows; together they break the rule. |

**PostgreSQL's levels:**
- **READ COMMITTED** (the default): each **statement** sees data committed before it started. No dirty
  reads, but non-repeatable reads, phantoms and lost updates are possible.
- **REPEATABLE READ:** the whole transaction sees one snapshot.
- **SERIALIZABLE:** behaves as if transactions ran one after another; some will fail and must be retried.

**Two tools that work at any level:**
- `SELECT ... FOR UPDATE` locks the rows it reads until commit, so another transaction trying to lock them **waits**.
- A **unique index** makes the database itself refuse a duplicate, whatever the application believed.

**Where you see it:** seat-reservation B3 stays at READ COMMITTED, locks the seat row with `FOR UPDATE`,
and keeps the partial unique index as the final guard.

## Self-check

1. Two reservations both check "is seat 7 free?", both see yes, and both insert. Which anomaly is this?
2. How does `FOR UPDATE` on the seat row prevent it?
3. Why keep a unique index as well?

<details><summary>Answers</summary>

1. A write-skew or lost-update style race (check-then-act): both acted on a check that became false.
2. The second transaction waits at the lock until the first commits, and then sees its reservation.
3. It guards the rule even if some code path forgets the lock.
</details>
