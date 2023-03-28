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

	var shouldReverse = code & (1 << uint(5-1))
	if shouldReverse != 0 {
		for i, j := 0, len(actions)-1; i < j; i, j = i+1, j-1 {
			actions[i], actions[j] = actions[j], actions[i]
		}
	}

	return actions
}
