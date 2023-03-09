package sieve

import "sort"

func Sieve(limit int) []int {
	if limit == 1 {
		return []int{}
	}

	var primes []int

	candidates := []int{limit}
	for c := 2; c < limit; c++ {
		candidates = append(candidates, c)
	}
	sort.Ints(candidates)

	for len(candidates) > 0 {
		itIsAPrime := candidates[0]
		primes = append(primes, itIsAPrime)

		var notAPrimeFactor = []int{}
		for i, v := range candidates {
			if i == 0 {
				continue
			}

			if v%itIsAPrime != 0 {
				notAPrimeFactor = append(notAPrimeFactor, v)
			}
		}

		candidates = notAPrimeFactor
	}

	return primes
}
