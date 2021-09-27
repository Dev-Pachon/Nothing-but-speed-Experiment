package main

import (
	"fmt"
	"math/rand"
	"time"
)

//Size 1 500
// const size = 500

//Size 2 5000
//const size = 5000

//Size 3 10000
const size = 10000

func fillRandom(arr []int) []int {

	rand.Seed(time.Now().UnixNano())
	for i := 0; i < len(arr); i++ {
		arr[i] = rand.Intn(100000)
	}

	return arr[:]
}

func fillAsc(arr []int) []int {

	rand.Seed(time.Now().UnixNano())
	for i := 0; i < len(arr); i++ {
		arr[i] = rand.Intn(100000)
	}

	temp := 0

	for j := 0; j <= len(arr)-2; j++ {
		for i := 0; i <= len(arr)-2; i++ {
			if arr[i] < arr[i+1] {
				temp = arr[i+1]
				arr[i+1] = arr[i]
				arr[i] = temp
			}
		}
	}

	return arr[:]
}

func fillDes(arr []int) []int {

	rand.Seed(time.Now().UnixNano())
	for i := 0; i < len(arr); i++ {
		arr[i] = rand.Intn(100000)
	}
	temp := 0

	for j := 0; j <= len(arr)-2; j++ {
		for i := 0; i <= len(arr)-2; i++ {
			if arr[i] < arr[i+1] {
				temp = arr[i+1]
				arr[i+1] = arr[i]
				arr[i] = temp
			}
		}
	}
	return arr[:]
}

func main() {
	for i := 0; i < 100; i++ {
		var arr [size]int
		ar := fillRandom(arr[:])
		sort(ar[:], false)
	}
	for i := 0; i < 100; i++ {
		var arr [size]int
		ar := fillAsc(arr[:])
		sort(ar[:], false)
	}
	for i := 0; i < 100; i++ {
		var arr [size]int
		ar := fillDes(arr[:])
		sort(ar[:], false)
	}
}

func sort(arr []int, one bool) {
	temp := 0
	start := time.Now()

	for j := 0; j <= len(arr)-2; j++ {
		for i := 0; i <= len(arr)-2; i++ {
			if arr[i] > arr[i+1] {
				temp = arr[i+1]
				arr[i+1] = arr[i]
				arr[i] = temp
			}
		}
	}
	elapsed := time.Since(start)
	if one {

		fmt.Println(elapsed.Nanoseconds())
	} else {
		fmt.Println(elapsed.Milliseconds())
	}

}
