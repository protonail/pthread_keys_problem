package main

import "C"

//export Get42
func Get42() C.int {
    return C.int(42)
}

func main() {
}
