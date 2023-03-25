package binarysearch

const KeyNotFound = -1

func SearchInts(list []int, key int) int {
	var leftBoundary, rightBoundary = 0, len(list) - 1

	for leftBoundary <= rightBoundary {
		var middleIndex = ((rightBoundary - leftBoundary) / 2) + leftBoundary
		if list[middleIndex] == key {
			return middleIndex
		}

		if key < list[middleIndex] {
			rightBoundary = middleIndex - 1
		} else {
			leftBoundary = middleIndex + 1
		}
	}

	return KeyNotFound
}
