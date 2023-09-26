# Java Test for Teladoc Health

## Requirement

Write a function that adds two strings, where each string represents an
arbitrarily large non-negative number.

function String addNumbers(String str1, String str2)

Examples:
- addNumbers("123456789012345678901", "12345678") should return
  "123456789012358024579".
- addNumbers("123", "11") should return "134".

## Solution

The addition of two arbitrarily large non-negative numbers and to not use BigInteger it does term by term in a reversed list.
For example: given this two numbers 123 and 12.

1. First it stores in a reversed list i.e. this number 123 it stores like this [3,2,1]
2. The sum of 123 + 12 it's do it like this [3,2,1] + [0,1,2] => 3+0, 2+1, 1+2 = 333

##  Possibles improvements
1. Change the type of property named values in NaturalNumber class from List to Array for performance purposes but depending on a load test and a profiling
2. Parametrize the bash scripts


## Build, Test and Execution

To build and run the solution it can use the listed below bash scripts

### Build (this is needed to be executed before run.sh to generate a jar)

`sh build.sh`

### Test

`sh test.sh`

### Run

`sh run.sh 123 12`

### Technology Stack

* Java11
* Junit
* Gradle
