package pangram

import "strings"

func IsPangram(input string) bool {
	uniqueCharacters := make(map[byte]struct{})
	allLower := strings.ToLower(input)

	for i := 0; i < len(allLower); i++ {
		thisChar := allLower[i]
		if thisChar >= 'a' && thisChar <= 'z' {
			_, isPresent := uniqueCharacters[thisChar]
			if !isPresent {
				uniqueCharacters[thisChar] = struct{}{}
			}
		}
	}
	return len(uniqueCharacters) == 26
}
