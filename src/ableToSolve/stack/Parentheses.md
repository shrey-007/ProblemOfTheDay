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
5. CheckIfParenthesesStringCanBeValid-: 
