package pangram

import "fmt"

func IsPangram(input string) bool {
	m := make(map[byte]struct{})

	for i := 0; i < len(input); i++ {
		// check for a to z!

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

	//unique_chars := []byte{}
	//
	//for i := 0; i < len(input); i++ {
	//	unique_chars = append(unique_chars, input[i])
	//}
	//
	//return len(unique_chars) == 26
}
