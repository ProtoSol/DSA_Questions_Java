class Solution:
    def licenseKeyFormatting(self, s: str, k: int) -> str:
        s = s.replace("-","").upper()

        N = len(s)
        leftover = N % k
        ans = []

        for i in range(leftover,N+1,k):
            if i >0:
                ans.append(s[max(i-k,0):i])

        return "-".join(ans)
        