package DSA_EXAM_QNS;

public class Qn_5 {
    // Define deadlock and how these can be protected in while writing multi threaded applications
    // A deadlock occurs in multi-threaded applications when two or more threads are blocked indefinitely, each waiting for the other to release a resource, causing the application to hang.

    // Conditions for Deadlock (Coffman Conditions)
    // Mutual Exclusion: Only one thread can use a resource at a time.
    
    // Hold and Wait: A thread holds a resource while waiting for another.
    
    // No Preemption: Resources cannot be forcibly taken from a thread.
    
    // Circular Wait: A circular chain of threads exists, each waiting for the next thread's resource.
    
    // Preventing Deadlocks
    // Avoid Nested Locks: Acquire locks in a fixed global order.
    
    // Use Timeouts: Release locks if they cannot be acquired within a specified time.
    
    // Avoid Hold and Wait: Acquire all required resources atomically.
    
    // Detect and Recover: Implement deadlock detection and break the deadlock by killing threads or preempting resources.
    
    // Use Concurrency Utilities: Leverage higher-level tools like thread pools and thread-safe data structures.
    
    // Limit Threads: Use a thread pool to control resource contention.
    
    // Design to Avoid Circular Wait: Ensure no circular dependencies between threads and resources.
}
