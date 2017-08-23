# Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
# steps at a time. Implement a method to count how many possible ways the child can run up the
# stairs. 

# BRUTE FORCE: You can start by climbing 1, 2, or 3 steps.
# So for n steps, add together all possibilites for (n-1), (n-2) and (n-3) steps.
# O(3^n)

def tripleStep(n):
    # base case
    if n == 0 or n == 1:
        return n
    # recurse on each of the 3 possibilities, then add (constant time)
    return tripleStep(n-1) + tripleStep(n-2) + tripleStep(n-3)

# DYNAMIC PROGRAMMING: use an array to cache the values of each n, for reusability

def tripleStep(n):
    memo = [-1]*(n-1)
    return count(n, memo)

def count(n, memo):
    # base cases
    if n < 0:
        return 0
    elif n == 0:
        return 1

    # if cached, return cached value
    elif memo[n] > -1:
        return memo[n]

    # if not cached, put it in the cache and return that
    else:
        memo[n] = count(n-1, memo) + count(n-2, memo) + count(n-3, memo)
        return memo[n]
