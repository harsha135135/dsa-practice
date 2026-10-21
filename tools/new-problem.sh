#!/usr/bin/env bash
# Adds a new exercise with a stub, a test, a reference-solution file, a problem page and an explanation page.
#
# Usage:   tools/new-problem.sh <topic-folder> <package> <ClassName> "<Exercise name>"
# Example: tools/new-problem.sh 01-arrays-and-hashing practice.arrays MajorityElement "Majority element"
set -euo pipefail

if [ "$#" -ne 4 ]; then
    echo "usage: $0 <topic-folder> <package> <ClassName> \"<Exercise name>\"" >&2
    exit 1
fi

topic="$1"
package="$2"
class="$3"
name="$4"
path="${package//.//}"
slug="$(echo "$name" | tr '[:upper:]' '[:lower:]' | tr -cs 'a-z0-9' '-' | sed 's/^-//; s/-$//')"
root="$(cd "$(dirname "$0")/.." && pwd)"

if [ ! -d "$root/topics/$topic" ]; then
    echo "no such topic folder: topics/$topic" >&2
    exit 1
fi
for f in "$root/src/main/java/$path/$class.java" "$root/topics/$topic/extra-$slug.md"; do
    if [ -e "$f" ]; then
        echo "already exists: $f" >&2
        exit 1
    fi
done

mkdir -p "$root/src/main/java/$path" "$root/src/test/java/$path" "$root/solutions/java/$path" "$root/solutions/explanations/$topic"

cat > "$root/src/main/java/$path/$class.java" <<JAVA
package $package;

/** Extra exercise: see topics/$topic/extra-$slug.md */
public final class $class {

    private $class() {
    }

    // TODO: write the method signature from the problem, and make its body:
    //     throw new UnsupportedOperationException("not solved yet");
}
JAVA

cat > "$root/solutions/java/$path/$class.java" <<JAVA
package $package;

/** Reference solution for the extra exercise "$name". Write it after solving, or copy a trusted one. */
public final class $class {

    private $class() {
    }
}
JAVA

cat > "$root/src/test/java/$path/${class}Test.java" <<JAVA
package $package;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ${class}Test {

    @Test
    void examples() {
        // TODO: one assertEquals per example from the problem statement.
    }

    // TODO: a random test that compares with a slow but obviously correct method.
}
JAVA

cat > "$root/topics/$topic/extra-$slug.md" <<MD
# $name (extra)

**Write it in:** \`src/main/java/$path/$class.java\` · **Test:** \`./mvnw test -Dtest=${class}Test\`

**Source:** (book, course or site, with a link)

## Problem

## Examples

## Limits

## Hints

<details><summary>Hint 1: a nudge</summary>

</details>

<details><summary>Hint 2: the approach</summary>

</details>

<details><summary>Hint 3: almost the answer</summary>

</details>
MD

cat > "$root/solutions/explanations/$topic/$slug.md" <<MD
# $name: explanation

**Simple way:**

**Bottleneck:**

**Better:**

**Why it is correct:**

**Cost:**
MD

echo "Created:"
echo "  topics/$topic/extra-$slug.md"
echo "  src/main/java/$path/$class.java"
echo "  src/test/java/$path/${class}Test.java"
echo "  solutions/java/$path/$class.java"
echo "  solutions/explanations/$topic/$slug.md"
