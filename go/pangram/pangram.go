package pangram

import "strings"

const numberUniqueCharacters = 26

func IsPangram(input string) bool {
	uniqueCharacters := make(map[byte]struct{})
	input = strings.ToLower(input)

	for i := 0; i < len(input); i++ {
		thisChar := input[i]
		_, alreadySeen := uniqueCharacters[thisChar]
		if thisChar < 'a' || thisChar > 'z' || alreadySeen {
			continue
		}
		uniqueCharacters[thisChar] = struct{}{}
	}
	return len(uniqueCharacters) == numberUniqueCharacters
}
