#!/usr/bin/env bash

# The following comments should help you get started:
# - Bash is flexible. You may use functions or write a "raw" script.
#
# - Complex code can be made easier to read by breaking it up
#   into functions, however this is sometimes overkill in bash.
#
# - You can find links about good style and other resources
#   for Bash in './README.md'. It came with this exercise.
#
#   Example:
#   # other functions here
#   # ...
#   # ...
#
#   main () {
#     # your main function code here
#   }
#
#   # call main with all of the positional arguments
#   main "$@"
#
# *** PLEASE REMOVE THESE COMMENTS BEFORE SUBMITTING YOUR SOLUTION ***
declare -a primes
declare -a sieve 
    
# mark all as prime up to limit
for ((i=2; i<=$1; i++)); do sieve[i]=1; done
       
for ((i=2; i<=$1; i++)); do
    (( sieve[i] )) || continue
    primes+=( $i )
    for ((j=2*i; j<=$1; j+=i)) do sieve[j]=0; done
done

echo "${primes[@]}"
