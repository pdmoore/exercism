package sieve

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

	for i := range candidates {
		//fmt.Println(candidates[i])
		primes = append(primes, candidates[i])
	}

	return primes

}
