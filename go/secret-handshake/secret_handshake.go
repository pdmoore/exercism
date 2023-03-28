package secret

func Handshake(code uint) []string {

	var actions []string

	var firstBitSet = code & (1 << uint(1-1))
	if firstBitSet != 0 {
		actions = append(actions, "wink")
	}

	//actions = append(actions, "double blink")

	return actions
}
