package binarysearch

func SearchInts(list []int, key int) int {

	if len(list) == 0 {
		return -1
	}

	var left = 0
	var right = len(list)

	if left == right && list[left] == key {
		return left
	}

	for left < right {
		var middleIndex = (right - left) / 2
		if list[middleIndex] == key {
			return middleIndex
		} else if key < list[middleIndex] {
			right = middleIndex - 1
		} else { // to the right
			left = middleIndex + 1
		}
	}

	return 0
}
