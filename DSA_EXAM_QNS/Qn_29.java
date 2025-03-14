package DSA_EXAM_QNS;

public class Qn_29 {
    // NP-Complete Problems
// Definition:
// A decision problem is in NP (nondeterministic polynomial time) if a given solution can be verified in polynomial time. A problem is NP-complete if it satisfies two conditions:

// NP Membership: The problem is in NP.
// NP-Hardness: Every problem in NP can be reduced to it in polynomial time.

// Examples of NP-Complete Problems:

// SAT (Boolean Satisfiability Problem): Determine if there exists an assignment of truth values to variables that makes a Boolean formula true.
// Clique Problem: Determine if a graph contains a complete subgraph of a given size.
// Brief Proof that "SAT is NP-Complete"
// The proof that SAT is NP-complete is established by the Cook-Levin Theorem. The key ideas of the proof are as follows:

// SAT is in NP:
// Given a Boolean formula and a truth assignment, verifying whether the formula evaluates to true can be done in polynomial time. This means SAT is a member of NP.

// SAT is NP-Hard:
// For any problem in NP, there exists a nondeterministic Turing machine that decides it in polynomial time. The Cook-Levin theorem shows that the computation of any such Turing machine can be encoded as a Boolean formula.

// Encoding Computation:
// The idea is to represent the steps of the Turing machine (its state, tape symbols, and head position) as variables in a Boolean formula.
// Satisfiability Equivalence:
// The constructed Boolean formula is designed such that it is satisfiable if and only if there exists an accepting computation path of the Turing machine on a given input.
// Polynomial-Time Reduction:
// This transformation—from an arbitrary NP problem (via its Turing machine representation) to an instance of SAT—can be carried out in polynomial time.
// Because every problem in NP can be reduced to SAT in polynomial time, SAT is NP-hard. Coupled with the fact that SAT is in NP, this establishes that SAT is NP-complete.

// Summary
// NP-complete problems are both in NP and NP-hard, meaning they are among the hardest problems for which a solution can be verified in polynomial time.
// Examples include SAT, 3-SAT, Hamiltonian Cycle, Vertex Cover, and Clique.
// The Cook-Levin Theorem provides the brief proof for SAT's NP-completeness by showing:
// SAT is in NP (verification is fast).
// Every problem in NP can be reduced to SAT (encoding Turing machine computations into Boolean formulas in polynomial time).
// This framework forms the cornerstone of NP-completeness theory and helps us understand the computational difficulty of many decision problems.
}
