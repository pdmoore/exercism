package linkedlist

import "fmt"

// Define List and Node types here.
// Note: The tests expect Node type to include an exported field with name Value to pass.
type Node struct {
	Value interface{}
	next  *Node
	prev  *Node
}

type List struct {
	first *Node
	last  *Node
}

func NewList(elements ...interface{}) *List {

	//TODO - elements looks like a []interface list of numbers
	// need to iterate that list, creating new Nodes and setting the value
	// linking the Nodes is either done here or as part of Node construction?

	var list = new(List)
	for index := 0; index < len(elements); index++ {
		list.Push(elements[index])
	}

	return list
}

func (n *Node) Next() *Node {
	return n.next
}

func (n *Node) Prev() *Node {
	panic("Please implement the Prev function")
}

func (l *List) Unshift(v interface{}) {
	panic("Please implement the Unshift function")
}

func (l *List) Push(v interface{}) {
	var node = new(Node)
	node.Value = v.(int)
	fmt.Printf("creating node with %v\n", v.(int))
	node.next = nil

	if l.first == nil {
		node.prev = nil

		l.first = node
	} else {
		l.last.next = node
		node.prev = l.last
	}
	l.last = node
}

func (l *List) Shift() (interface{}, error) {
	panic("Please implement the Shift function")
}

func (l *List) Pop() (interface{}, error) {
	panic("Please implement the Pop function")
}

func (l *List) Reverse() {
	panic("Please implement the Reverse function")
}

func (l *List) First() *Node {
	return l.first
}

func (l *List) Last() *Node {
	return l.last
}
