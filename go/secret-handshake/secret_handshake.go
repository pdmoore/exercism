package secret

var actions = map[uint]string{
	0b0001: "wink",
	0b0010: "double blink",
	0b0100: "close your eyes",
	0b1000: "jump",
}

func Handshake(code uint) []string {
	var resultingActions []string
	for i := 0; i < len(actions); i++ {
		var bitIndex uint = 0x1 << i
		if code&bitIndex > 0 {
			resultingActions = append(resultingActions, actions[bitIndex])
		}
	}

	if shouldReverse(code) {
		resultingActions = reverse(resultingActions)
	}

	return resultingActions
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
