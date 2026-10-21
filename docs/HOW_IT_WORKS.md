# How this repo works

## One set of tests, two sets of code

The tests in `src/test/java` can run against two different folders of code. `pom.xml` decides which one:

```xml
<sourceDirectory>${practice.sources}</sourceDirectory>   <!-- default: src/main/java -->
```

| Command | Code under test | Use it for |
|---|---|---|
| `./mvnw test` | `src/main/java` (your solutions) | practising |
| `./mvnw test -Psolutions` | `solutions/java` (reference) | checking that the tests are right (CI does this) |

Both folders contain the **same class names in the same packages**, so the tests compile against
either. Only one folder is compiled at a time.

## Why unsolved exercises show as "skipped"

Every stub throws `new UnsupportedOperationException("not solved yet")`. A small JUnit extension,
`src/test/java/practice/support/NotSolvedYet.java`, catches exactly that exception and reports the
test as **skipped** instead of failed. JUnit finds the extension automatically, because:

- `src/test/resources/META-INF/services/org.junit.jupiter.api.extension.Extension` names it, and
- `src/test/resources/junit-platform.properties` turns on automatic detection.

With `-Psolutions`, the property `practice.solutions=true` switches this off, so a missing reference
solution is a real failure.

## How the tests check you

Most test classes have two kinds of test:
1. **Examples**: the cases from the problem page, written out by hand.
2. **Random comparisons**: hundreds of small random inputs, each checked against a slow but obviously
   correct method written inside the test (for example, trying every pair). The `Random` has a fixed
   seed, so a failure repeats exactly.

Some also have a **big input** test that a too-slow solution will not finish quickly.
