class Solution:
    def isSubstringPresent(self, s: str) -> bool:


        for i in range(len(s) - 1):

            s1 = s[i:i+2]
            s2 = s1[::-1]

            if s2 in s:
                return True
            
        return False
        