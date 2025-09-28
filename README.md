# Assignment 1 — Divide and Conquer Algorithms

## What I did
In this project I worked with four classic divide-and-conquer algorithms in Java:  
- **MergeSort**  
- **QuickSort**  
- **Deterministic Select (Median of Medians)**  
- **Closest Pair of Points (2D)**  

Each algorithm was implemented with safe recursion patterns and some practical optimizations.  
The code is organized as a Maven project (`src/main/java` and `src/test/java`).  

I also wrote **40 JUnit tests** (10 for each algorithm). These tests check edge cases like empty arrays, single elements, sorted and reverse input, duplicates, negative numbers, random arrays, and geometric cases for Closest Pair. All tests passed.  

Finally, I added a **Metrics system** that measures:  
- number of comparisons  
- number of allocations  
- recursion depth  
- execution time  

This made it possible to compare theory with actual measurements.  

---

## Algorithms

### MergeSort
- Splits the array into halves, sorts recursively, and merges back.  
- Used a reusable buffer and a cutoff for small inputs (switch to insertion sort).  
- **Recurrence**: T(n) = 2T(n/2) + Θ(n).  
- **Result**: Master Theorem Case 2 → Θ(n log n).  

### QuickSort
- Uses a randomized pivot.  
- Always recurses on the smaller side first to keep recursion depth safe.  
- **Runtime**: average Θ(n log n), worst-case Θ(n²).  
- Depth bounded by O(log n) with high probability.  

### Deterministic Select
- Median-of-medians pivot (groups of 5).  
- Only recurses into the side containing the k-th element.  
- **Recurrence**: T(n) ≤ T(n/5) + T(7n/10) + Θ(n).  
- **Result**: Θ(n) (Akra–Bazzi).  

### Closest Pair of Points (2D)
- Sorts by x, splits recursively, and checks a strip around the midpoint in y-order.  
- Each point checks only a constant number of neighbors.  
- **Recurrence**: T(n) = 2T(n/2) + Θ(n).  
- **Result**: Θ(n log n).  

---

## Testing
For every algorithm I wrote 10 JUnit tests (40 total).  
The tests included:  
- empty inputs  
- trivial cases (one or two elements)  
- already sorted / reverse-sorted arrays  
- duplicates and negative numbers  
- large random arrays  
- geometric corner cases for Closest Pair  

All tests passed.  

---

## Metrics
The `Metrics` class tracks comparisons, allocations, recursion depth, and execution time.  

Findings:  
- MergeSort and QuickSort grew close to n log n.  
- Deterministic Select grew linearly.  
- Closest Pair also grew near n log n.  
- Depth and allocations behaved as predicted.  

This matched the theoretical analysis (Master theorem and Akra–Bazzi).  

---

## Git & Workflow
I followed a GitHub workflow with branches and commits.  

**Branches**:  
- `main` — releases (tagged v0.1, v1.0)  
- `feature/mergesort`, `feature/quicksort`, `feature/select`, `feature/closest`, `feature/metrics`  
- `refactor/util`, `docs/report`  

**Commit storyline** (examples):  
- `init: maven, junit5, ci, readme`  
- `feat(mergesort): baseline + buffer reuse + cutoff`  
- `feat(quicksort): smaller-first recursion + randomized pivot`  
- `feat(select): deterministic select (MoM5)`  
- `feat(closest): divide-and-conquer algorithm`  
- `feat(metrics): counters and depth tracker`  
- `docs(report): recurrence analysis and results`  
- `release: v1.0`  

---

## Conclusion
- Implemented **4 divide-and-conquer algorithms** in Java.  
- Verified correctness with **JUnit tests (40/40 passed)**.  
- Collected metrics (time, depth, allocations, comparisons).  
- Analyzed running times with **Master theorem** and **Akra–Bazzi**.  
- Experiments confirmed theoretical analysis.  
- Used a clean **GitHub branching and commit workflow**.  
- Project ready for submission.  
