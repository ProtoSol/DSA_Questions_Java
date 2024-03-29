class Solution:
    def isSubstringPresent(self, s: str) -> bool:

        # Will try Later in java for better Optimization.

        N = len(s)
        r = "".join(reversed(list(s)))

        for i in range(1,N):
            if s[i-1] + s[i] in r:
                return True
        return False