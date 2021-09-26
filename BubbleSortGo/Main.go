package main

import (
	"math/rand"
	"time"
)

var times = 0.1
var sizeOne = 500
var sizeTwo = 5000
var sizeThree = 10000

func timeMeasurement(start time.Time) {
	elapsed := time.Since(start)
	times = float64(elapsed.Milliseconds())
}

func fillRandom() {
	var v [size]int
	rand.Seed(time.Now().UnixNano())
	for i := 0; i < 5; i++ {
		v[i] = rand.Intn(100000)
	}
}

func main() {

}

func timeMeasure() {
	defer timeMeasurement(time.Now())
	sort()
}

func sort(arr []int) {

	temp := 0

	for j := 0; j <= len(arr)-2; j++ {
		for i := 0; i <= len(arr)-2; i++ {
			if arr[i] > arr[i+1] {
				temp = arr[i+1]
				arr[i+1] = arr[i]
				arr[i] = temp
			}
		}
	}

}
