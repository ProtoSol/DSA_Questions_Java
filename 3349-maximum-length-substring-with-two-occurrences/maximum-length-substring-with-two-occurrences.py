class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        N = len(s)
        best = 0

        for i in range(N):
            f = collections.Counter()

            for j in range(i, N):
                f[s[j]] += 1

                if max(f.values()) <= 2:
                    best = max(best, j - i + 1)
                else:
                    break
        
        return best