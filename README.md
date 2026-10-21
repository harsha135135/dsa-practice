# dsa-practice

A **practice gym** for data structures and algorithms. It is not a collection of answers:
each exercise has a problem statement, examples, tests, three hints that give away more and
more, and a reference solution kept **in a separate folder** for after you have tried.

> Where this fits: DSA practice runs alongside every stage of the
> [learning path](https://github.com/harsha135135/seat-reservation/blob/main/docs/LEARNING_PATH.md).

## Be honest about what this proves

The 40 exercises here are a **starting set**. Solving them does not show broad DSA skill.
What shows it is your [practice log](PRACTICE_LOG.md): many problems, including ones you had
never seen, solved without hints, explained in your own words, and solved **again** weeks later.
Use `tools/new-problem.sh` to keep adding problems from books, courses or interview sites.

## How to practise one exercise

1. Open the topic, e.g. [topics/01-arrays-and-hashing](topics/01-arrays-and-hashing/README.md), and pick an exercise.
2. Read the problem. **Before coding**, write down the simple solution and its cost.
3. Write your code in the stub, in `src/main/java/practice/...`.
4. Run its tests:
   ```bash
   ./mvnw test -Dtest=TwoSumTest
   ```
5. Stuck for 20 minutes or more? Open **one** hint, then try again.
6. When the tests pass, write your own correctness and cost note in the log, and **only then**
   read the explanation in `solutions/explanations/`.
7. Schedule revisits: about 3 days, 2 weeks and 2 months later. Solve it again **from a blank stub**
   (`git stash` or copy your answer away first).

## What the test results mean

| You see | Meaning |
|---|---|
| **skipped** | not solved yet: the stub still throws `not solved yet` |
| **passed** | your solution works on the examples and on hundreds of random cases |
| **failed** | your solution gives a wrong answer; the message shows the input |

`./mvnw test` runs everything: unsolved exercises show as skipped, so only real mistakes are red.

## Checking the tests themselves

```bash
./mvnw test -Psolutions
```

This runs the **same tests** against the reference solutions in `solutions/java/`. CI runs it on
every push, so the tests and solutions are known to agree. While writing them, this check caught
three mistakes in my own hand-written expected values.

## Layout

```
topics/<nn-topic>/            problem statements and hints (start here)
src/main/java/practice/...    YOUR code (stubs to fill in)
src/test/java/practice/...    the tests
solutions/java/practice/...   reference code (look after trying)
solutions/explanations/...    why the reference is correct, and its cost
concepts/                     short notes on core computer-science ideas, with self-check questions
PRACTICE_LOG.md               your record of attempts and revisits
tools/new-problem.sh          adds a new exercise with all of the above
```

## Topics

| # | Topic | Learning-path stage |
|---|---|---|
| 1 | [Arrays, strings, hash maps, prefix sums](topics/01-arrays-and-hashing/README.md) | plain Java reservation logic |
| 2 | [Sorting, binary search, two pointers, sliding windows](topics/02-sorting-and-searching/README.md) | plain Java reservation logic |
| 3 | [Linked lists, stacks, queues](topics/03-lists-stacks-queues/README.md) | HTTP server |
| 4 | [Recursion and backtracking](topics/04-recursion-and-backtracking/README.md) | PostgreSQL and transactions |
| 5 | [Trees, BSTs, heaps, tries](topics/05-trees-heaps-tries/README.md) | Spring Boot and login |
| 6 | [Graphs, BFS, DFS, topological sort](topics/06-graphs/README.md) | Linux and cloud |
| 7 | [Shortest paths, union-find, greedy](topics/07-paths-union-find-greedy/README.md) | Linux and cloud |
| 8 | [Dynamic programming and bit operations](topics/08-dynamic-programming-and-bits/README.md) | search engine |

Each topic has five exercises: one "build it", three graded problems (warm-up, standard, harder),
and one to do **at least a week later**, without being told which idea it uses.

## More

- [How this repo works](docs/HOW_IT_WORKS.md): the Maven switch and the "skipped" trick.
- [Glossary](docs/GLOSSARY.md): Big-O and other words in plain English.
- [Concepts](concepts/README.md): process vs thread, virtual memory, TCP vs UDP, transaction anomalies, and more.
