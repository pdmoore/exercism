declare -a primes
declare -a sieve 
limit=$1
    
# mark all as prime up to limit
for ((i=2; i<=$limit; i++)); do sieve[i]=1; done
       
for ((i=2; i<=$limit; i++)); do
    (( sieve[i] )) || continue
    primes+=( $i )
    for ((j=2*i; j<=$limit; j+=i)) do sieve[j]=0; done
done

echo "${primes[@]}"
