package pangram

import "fmt"

func IsPangram(input string) bool {
	m := make(map[byte]struct{})

	for i := 0; i < len(input); i++ {
		thisChar := input[i]
		if thisChar >= 'a' && thisChar <= 'z' {
			_, isPresent := m[thisChar]
			if !isPresent {
				m[thisChar] = struct{}{}
			}
		}
	}
	fmt.Println(m)
	return len(m) == 26
}
