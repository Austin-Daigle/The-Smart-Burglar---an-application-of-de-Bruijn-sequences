# The Smart Burglar: an application of De Bruijn sequences
This project was orignally designed and writtein in Fall 2020.

## Table Of Contents:




## Abstract:
This project's focus is to develop an algorithmic process to create a string of 10,003 numerical characters that tests all possible combinations on a four-digit (zero through nine) electronic combination lock. The advantage of this process would save an enormous amount of time when testing hardware or gaining unauthorized access into secured equipment or locations; because, instead of entering 40,000 characters to test all 10,000 possible combinations, you would instead only need to enter 10,003 characters; thus, increasing your efficiency by nearly three-fold (Berry).

## Introduction:

The hypothetical prompt that inspired the need for the algorithmic process mentioned above is called “The Clever Burglar.” The premise of “The Clever Burglar” is that a burglar is attempting to enter a hotel room. However, the aforementioned room has a combination (zero through nine) on the door that requires the correct four-digit combination to grant access
The burglar wishing to enter the room wants a sequence of numerical characters that tests all possible combinations on the lock. It is important to note that in this hypothetical scenario, the combination lock mentioned (unlike modern combination locks) does not require the user to press an “enter” key; It does not disable itself after an amount of failed attempts, or alert security, or set off an alarm, Most importantly, it does not automatically clear all of its memory when the entered digits exceed the four-digit memory limit.

Alternatively, the way the memory in this lock works is that when a new digit is entered into memory (after already having four digits entered), the first digit to be entered gets deleted, and the current values in memory shift over to the left by one space. This feature (or rather a massive flaw) allows for an individual to test multiple combinations for each digit entered after the first four digits; this condition allows for an algorithm to be made to exploit this flaw.

The algorithm that will be used to solve this problem is called the De Bruijn Sequence, a De Bruijn sequence is a sequence in which every feasible length of string-_n_ under the dictionary of _k_ is possible as a continuous sequence, _n_ represents the digit string length allows for the operation while the variable _k_ represents the alphabet of either all supported characters (or in this case a numerical range) (Berry). The sequence contains one instance of each unique combination when a substring is derived from the being index selected and the ending end (the beginning index plus the value of _n_) (please see Table A below view an example of this concept) (Berstel).

![image](https://user-images.githubusercontent.com/100094056/193476310-1226fb66-2db9-4306-9e24-6dfb9ee8f75f.png)

De Bruijn sequences can be synthesized using a variety of algorithms and methods, the most common methods used are the Hamiltonian path, shift registers, the Eulerian cycle, and an Inverted Burrows-Wheelers function. However, the process that was implemented for this development was the Lyndon Words algorithm, this was chosen due to its ability to be relatively efficient yet straightforward (Berry).

A Lyndon Word is a string that is populated (non-empty) and is exactly smaller than all of the lexicographic (or, in this case, the order of a pre-ordered set) of all of the rotations of a given dictionary string (Sawada). The Lyndon Words string will be used to rotate through the dictionary string for this process and then augment the final result to construct the desired De-Bruijn string. The subsequent string can be deconstructed to analyze and verify the result, and in application, fulfill the requirements of solving for all possible combinations (Berstel).

## Background:
As mentioned above, the Lyndon words algorithm operates on the smallest string object that is lexicographically equivalent to the _k_\-dictionary string. These strings are called “necklaces.” Logically speaking, an aperiodic form of a _necklace_ would equal a _Lyndon word_. The object is to extract the Lyndon Words from the input to generate the De-Bruijn sequence upon each recursion, view Table B and Table C below to see a representation of the process above.

![image](https://user-images.githubusercontent.com/100094056/193476295-3b1924bd-cebd-420b-9c9d-818a9af83c40.png)

![image](https://user-images.githubusercontent.com/100094056/193476331-02e86577-370d-4f85-931a-5c2c37d4ec70.png)


The following theorem was directly referenced from _A fast algorithm to generate necklaces with fixed content_ by Joe Sawada as the referenced core that derived the algorithm that was converted and eventually coded into Java. 

A note for the reader: I do not claim credit for the original algorithm, but instead, I cited the author and source material, and I instead created a derivative adaptation based on the source work, some changes were made from the original function and the Java adaption to correct for the limitation and nuances within the Java programming language.

![image](https://user-images.githubusercontent.com/100094056/193476484-c7834223-48b3-4877-a192-e510fd76f096.png)

Using the algorithm given from the reference above, it is possible to convert it to a recursive algorithmic runtime with similar variables to the original theorem (Sawada). The method shown above can be described as a statement of: if α is representative of a pre-necklace with the function of _p = lyn(α)_, then α can be necklace if it has a _n modulus_ of _p_ that is equivalent to zero and it shares the relation of _n_ is directly equal to _p_ concurrently; then _theorem 1_ from above can be said to be true, and the necklace (or selected characters) can be added or printed out to the sequence. The string object (or array object) remains constant, assuming the dictionary (k-value) remains constant for the purpose of alternation and computation. _Theorem 1_, in application, will recurse multiple times until each subroutine is complete without anymore stack (or user) recursion calls to itself; this function does not feature “break” statements or user-stop base cases in this algorithm to terminate this process.

Below is the adapted pseudocode from the first revision of pseudocode from _Theorem 1_ from the cited text (Sawada); some changes have been made to the pseudocode below to allow for capability with the java adaptation.


### Pseudocode adapted from _Theorem 1_
	procedure simpleFixedContent( t, p: integer)
	Local j: integer
	Begin
		If t > n then begin
			If n mod p = 0 then
				Print();
			endIf;
		endIf;
		else begin
			for j ∈ {at-p,…,k-2,k-1} do begin
				at: = j;
				if j := at-p then simpleFixedContent( t + 1 , p );
				endIf;
				else begin simpleFoxedContent( t + 1 , t );
				endElse;
			endFor;
		endElse;
	end;

## The Original Algorithm:

The algorithm that will be adapted into Java is derived from Theorem 1 (see above) with a few modifications (further modifications will be taken to necessitate the conversion to Java). This algorithm's primary concept is to repeatedly and recursively extend pre-necklaces until they equal the length of _n_ (Sawada). The pre-necklaces that are not necklaces will not be extended into the final sequence. The general process starts upon execution; local variables and parameters are initialized. The value of _t_ and _p_ are declared to the value of 1 (at they are variables for the purpose of controlling the alternation and assignments of data to/from the pre-necklace object (sized at _n_+1)). The first if statement within the algorithm evaluates whether the value of _t_ is greater than the value of _a.length-1_ (one minus the pre-necklace object); when true, then a second if statement is evaluated. The second if statement checks to see if the value of the modulus of (_a.length-1_) and _p_ equals zero, if true, then for every value from 1 to (_p+1_) append the final output by the given character present in _a_ at the value of the for loop at that iteration.

If the root if statement evaluates to false, then the else statement will execute the following process: change the current numerical value at index value _t_ in the object _a_ to the current value index value of _t-p_ in _a_ (this part is one section that changes the value in the pre-necklace object for the sake of rotation)_,_ then call a recursion of the algorithm with all of the current value but augment the value of _t_ by 1, then for each value between ((the current numerical value of _a_ at the index of _t-p_) plus 1) to _k-1_: change the present value of _a_ at the index of the value of _j_ and also recurse the whole algorithm but with the value of _t_ incremented by 1. This algorithm terminates when each “parent” and “child” execute and complete their respective subroutines to completion until no other recursions are called, and all called processes are exhausted (Sawada).

On a final note with the final Java adaption, the primary change that was implemented to make the function work was to have a post-process subroutine that adds _n-2_ zeroes to the end of the De Bruijn sequence to complete the “rollover.” Other changes were slight changes to the recursion calls, objects/variables used (to get around Java object limits), and a validation routine that cross-references all of the possible combinations to the Da-Bruijn (this is only enabled in the _n­_ = 4 and _k_ = 10 demo) and prints the final result.

## The 10,003 Digits:
