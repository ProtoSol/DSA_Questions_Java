class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        b=s[::-1]
        for i in range(1,len(s)):
            if (s[i-1]+s[i]) in b:
                return True
        return False

        