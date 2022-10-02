# The Smart Burglar: an application of De Bruijn sequences

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



