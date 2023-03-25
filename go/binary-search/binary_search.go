package binarysearch

const KeyNotFound = -1

func SearchInts(list []int, key int) int {
	if len(list) == 0 {
		return KeyNotFound
	}

	var left = 0
	var right = len(list) - 1

	for left <= right {
		var middle = ((right - left) / 2) + left
		if list[middle] == key {
			return middle
		} else if key < list[middle] {
			right = middle - 1
		} else {
			left = middle + 1
		}
	}

	return KeyNotFound
}
