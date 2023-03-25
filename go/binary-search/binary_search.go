package binarysearch

import "fmt"

func SearchInts(list []int, key int) int {

	if len(list) == 0 {
		return -1
	}

	var left = 0
	var right = len(list) - 1

	for left <= right {
		var middle = ((right - left) / 2) + left
		fmt.Println("key: ", key)
		fmt.Println("left: ", left)
		fmt.Println("right: ", right)
		fmt.Println("middle: ", middle)
		fmt.Println("value at mid: ", list[middle])
		if list[middle] == key {
			return middle
		} else if key < list[middle] {
			right = middle - 1
		} else { // to the right
			left = middle + 1
		}
	}

	return -1
}
