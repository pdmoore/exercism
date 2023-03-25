package binarysearch

func SearchInts(list []int, key int) int {

	if len(list) == 0 {
		return -1
	}

	var middleIndex = len(list) / 2
	if list[middleIndex] == key {
		return middleIndex
	}

	return 0
}
