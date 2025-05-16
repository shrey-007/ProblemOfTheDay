1. Valid Parentheses-: Given a string s, check whether it is a valid Parentheses or not
   - Take a variable count  = 0
   - when you encounter a (, do count++
   - when you encounter a ), do count--
   - if at any time means closing jyaada hogye, toh it is invalid
   - poori string ko iterate krne ke baad count==0 hona chaiye, agar count>0 hai toh means opening brackets jyaada hai toh invalid hai
   - This method works only if 2 brackets ho ( and ). But agar [,{,],}  hoge toh ye fail hoga toh stack use krna
2. MinimumAddToMakeParenthesesValid-: Return minimum number of ( or ) required to add to make s valid
   - Take same variable count = 0, and do count++ on '(' ,  and count-- on ')'
   - If at anytime count<0 means ki ek closing bracket jyaada hai toh we need to add one opening bracket to make it valid. ans++
   - If at the end of the loop, count>0 means ki opening bracket jyaada hai toh jitne opening bracket jyaada hai utne hi closing add kro toh count ko hi add krdo ans mai. ans += count
3. MinRemoveToMakeValid - : Return min number of parethesis need to remove to make the s valid
   - Same code of above will work.
4. MinimumSwapsToMakeStringValid-: Given string of length 2n. It contains n opening and n closing brackets, but hey may be shuffled and forming a non-balanced string, find minimum swaps to make it balanced
   - This time count pointer will not work.
   - We need to find number of closing brackets which are at wrong position.
   - Let number of closing brackets that are at wrong positions are x, and length of string is n. Now if(n%2==0) then return x/2 else return x/2+1
   - Now how will you find x?, you can't find it using count.
   - Take a open and close pointer, and increase the open when open bracket and close when close bracket
   - Whenever you encounter close>open, increase x.
   - You can also do it using count, see the code(3 approaches)
5. CheckIfParenthesesStringCanBeValid-: Given a string of paranthesis, and a string locked. You can change a character if it is unlocked, otherwise you can't change a locked character. Check if we can make the string valid
   - You can't do anything to the locked indexes
   - So if you encounter a locked index-:
      - If it is '(', just push it to the stack
      - If it is ')', it needs to get balanced by some '(', toh dekho stack mai '(' hai kya if yes then good, it got balanced, if no, then try to balance it by unlocked index, usko '(' bana do.
   - So u just need 2 stacks, 1 one the real simulation (standard that we used to use), and one for unlocked indexes. Unlocked valo ko either ( or ) dono ko hi 2nd stck mai daalo. and locked vaalo ko real stack mai daalo 
   - After whole iteration, if the real stack is not empty means , opening bracket balance nhi hue, toh unlocked valo se balance karo, and opening brakctes ko unke baad vaale unlocked indexes hi balance kr skte hai , unke pehle vaale nhi
6. LongestValidParentheses(Leetcode Hard)-: 
7. Generate Parentheses-: given a number n, form a valid balanced string of size 2n.
   - This is try all possible ways
   - at every index we have 2 options, either we put '(' or ')'
   - we can only take ')' if count of '(' is lesser than it.
   - we want count of both '(' = count of ')' = n
8. RemoveInvalidParentheses(Leetcode Hard)-: 
9. Score of Parentheses-: Not yet solved on leetcode
10. 