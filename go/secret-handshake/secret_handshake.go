package secret

func Handshake(code uint) []string {

	var actions []string

	if code&(1<<uint(1-1)) != 0 {
		actions = append(actions, "wink")
	}

	if code&(1<<uint(2-1)) != 0 {
		actions = append(actions, "double blink")
	}

	if code&(1<<uint(3-1)) != 0 {
		actions = append(actions, "close your eyes")
	}

	if code&(1<<uint(4-1)) != 0 {
		actions = append(actions, "jump")
	}

	if shouldReverse(code) {
		actions = reverse(actions)
	}

	return actions
}

func shouldReverse(code uint) bool {
	return code&(1<<uint(5-1)) != 0
}

func reverse(actions []string) []string {
	for i, j := 0, len(actions)-1; i < j; i, j = i+1, j-1 {
		actions[i], actions[j] = actions[j], actions[i]
	}

	return actions
}
