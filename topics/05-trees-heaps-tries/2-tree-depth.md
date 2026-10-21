# 5.2 Tree depth (warm-up)

**Write it in:** `src/main/java/practice/trees/TreeDepth.java` · **Test:** `./mvnw test -Dtest=TreeDepthTest`

## Problem

Return the **depth** of a binary tree: the number of nodes on the longest path from the root down to a
leaf. An empty tree (`null`) has depth `0`. `TreeDepth.Node` is a record with `value`, `left`, `right`.

## Examples

```
    3
   / \
  9  20
     / \
    15  7
```
Depth `3`. A single node has depth `1`.

## Limits

Small trees; the deepest test is 51 levels.

## Hints

<details><summary>Hint 1: a nudge</summary>

If you knew the depth of the left subtree and of the right subtree, what would the whole tree's depth be?
</details>

<details><summary>Hint 2: the approach</summary>

Depth of a tree = 1 + the larger of the two subtree depths. What is the depth of an empty tree?
</details>

<details><summary>Hint 3: almost the answer</summary>

`if (root == null) return 0; return 1 + Math.max(maxDepth(root.left()), maxDepth(root.right()));`
</details>

## After you solve it

Log it in `PRACTICE_LOG.md`. Write your own correctness and cost note, **then** compare it with
`solutions/explanations/05-trees-heaps-tries/tree-depth.md`.
