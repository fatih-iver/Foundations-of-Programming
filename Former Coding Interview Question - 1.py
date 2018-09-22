
S = "abppplee"  

D = ["able", "ale", "apple", "bale", "kangaroo"]

def getLongestSubsequence(S, D):
   
    D.sort(key=len, reverse=True)
    print(D)
    for W in D:
        if isSubsequence(S, W):
            return W


    
def isSubsequence(S, W):
    
    indexStart = -1
    for C in W:
        charIndex = S.find(C, indexStart + 1)
        if charIndex == -1:
            return False
        
        indexStart = charIndex
    return True
        
        
print(getLongestSubsequence(S, D))
    