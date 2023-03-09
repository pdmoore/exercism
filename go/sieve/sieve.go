package sieve

import "sort"

func Sieve(limit int) []int {
	if limit == 1 {
		return []int{}
	}

	//// loop through that and remove multiples of current index
	//candidates := make([]int, limit)
	//for i := 2; i < limit; i++ {
	//	candidates[i-2] = i
	//}

	//return candidates

	//var primes []int
	//for j := range candidates {
	//	primes = append(primes, candidates[j])
	//}
	//
	//return primes

	var primes = []int{}

	candidates := []int{limit}
	for c := 2; c < limit; c++ {
		candidates = append(candidates, c)
	}
	sort.Ints(candidates)

	//  remove non-primes from candidates

	for len(candidates) > 0 {
		primes = append(primes, candidates[0])

		isPrime := candidates[0]
		var remainingCandidates = []int{}

		for i, v := range candidates {
			if i == 0 {
				continue
			}

			if v%isPrime != 0 {
				remainingCandidates = append(remainingCandidates, v)
			}
		}

		candidates = remainingCandidates

	}

	//for i := range candidates {
	//	//fmt.Println(candidates[i])
	//	primes = append(primes, candidates[i])
	//}

	return primes

}
