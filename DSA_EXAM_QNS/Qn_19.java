package DSA_EXAM_QNS;

public class Qn_19 {
//     Below is a concise walkthrough of Kruskal’s Algorithm to find a maximum spanning tree (MST) for the given 6‐vertex graph 
// {
// 𝐴
// ,
// 𝐵
// ,
// 𝐶
// ,
// 𝐷
// ,
// 𝐸
// ,
// 𝑍
// }
// {A,B,C,D,E,Z}. (The same steps can be adapted for Prim’s Algorithm, but Kruskal’s is often simpler to illustrate.)

// 1. List All Edges and Sort by Descending Weight
// (Exact edges and weights come from the diagram. Suppose the edges are as follows—adjust if your diagram differs slightly.)

// 𝐵
// −
// 𝐶
// =
// 5
// B−C=5
// 𝐷
// −
// 𝐸
// =
// 5
// D−E=5
// 𝑍
// −
// 𝐷
// =
// 3
// Z−D=3
// 𝐴
// −
// 𝐵
// =
// 2
// A−B=2
// 𝐶
// −
// 𝑍
// =
// 2
// C−Z=2
// 𝐸
// −
// 𝐴
// =
// 2
// E−A=2
// 𝐵
// −
// 𝐷
// =
// 2
// B−D=2
// 𝐵
// −
// 𝐸
// =
// 1
// B−E=1
// Sorted from largest to smallest weight:

// 𝐵
// −
// 𝐶
// =
// 5
// B−C=5
// 𝐷
// −
// 𝐸
// =
// 5
// D−E=5
// 𝑍
// −
// 𝐷
// =
// 3
// Z−D=3
// 𝐴
// −
// 𝐵
// =
// 2
// A−B=2
// 𝐶
// −
// 𝑍
// =
// 2
// C−Z=2
// 𝐸
// −
// 𝐴
// =
// 2
// E−A=2
// 𝐵
// −
// 𝐷
// =
// 2
// B−D=2
// 𝐵
// −
// 𝐸
// =
// 1
// B−E=1
// We need exactly 
// 𝑉
// −
// 1
// =
// 6
// −
// 1
// =
// 5
// V−1=6−1=5 edges for the spanning tree.

// 2. Kruskal’s Steps (Pick from Largest Down, Avoid Cycles)
// Pick 
// 𝐵
// −
// 𝐶
// =
// 5
// B−C=5.
// No cycle, include it.
// Pick 
// 𝐷
// −
// 𝐸
// =
// 5
// D−E=5.
// No cycle, include it.
// Pick 
// 𝑍
// −
// 𝐷
// =
// 3
// Z−D=3.
// No cycle, include it.
// Pick 
// 𝐴
// −
// 𝐵
// =
// 2
// A−B=2.
// No cycle, include it.
// Pick 
// 𝐶
// −
// 𝑍
// =
// 2
// C−Z=2 (or any other 2‐weight edge that connects the remaining vertices without forming a cycle).
// This merges all vertices into a single connected component.
// Now we have 5 edges for our 6 vertices, which forms a spanning tree. We stop here.

// 3. Maximum Spanning Tree and Weight
// Chosen Edges:

// 𝐵
// −
// 𝐶
// =
// 5
// B−C=5
// 𝐷
// −
// 𝐸
// =
// 5
// D−E=5
// 𝑍
// −
// 𝐷
// =
// 3
// Z−D=3
// 𝐴
// −
// 𝐵
// =
// 2
// A−B=2
// 𝐶
// −
// 𝑍
// =
// 2
// C−Z=2
// Total Weight 
// =
// 5
// +
// 5
// +
// 3
// +
// 2
// +
// 2
// =
// 17
// =5+5+3+2+2=17.

// Hence, the maximum spanning tree has a total weight of 17, using the five edges listed above.
}
