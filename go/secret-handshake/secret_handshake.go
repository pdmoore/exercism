package secret

func Handshake(code uint) []string {

	var actions []string

	var firstBitSet = code & (1 << uint(1-1))
	if firstBitSet != 0 {
		actions = append(actions, "wink")
	}

	if code&(1<<uint(2-1)) != 0 {
		actions = append(actions, "double blink")
	}

	if code&(1<<uint(3-1)) != 0 {
		actions = append(actions, "close your eyes")
	}

	return actions
}
