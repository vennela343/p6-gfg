class Solution:
    def caseSort(self,s):
        #code here
        upper = sorted([ch for ch in s if ch.isupper()])
        lower = sorted([ch for ch in s if ch.islower()])
        
        result = []
        i = j = 0  

        for ch in s:
            if ch.isupper():
                result.append(upper[i])
                i += 1
            else:
                result.append(lower[j])
                j += 1
        
        return ''.join(result)
