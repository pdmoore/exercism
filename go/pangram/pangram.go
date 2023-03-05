package pangram

func IsPangram(input string) bool {
	m := make(map[byte]bool)

	for i := 0; i < len(input); i++ {
		if m[input[i]] != true {
			m[input[i]] = true
		}
	}

	return len(m) == 26
}
