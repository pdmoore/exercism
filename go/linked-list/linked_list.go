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
	return n.prev
}

func (l *List) Unshift(v interface{}) {
	var newFirst = new(Node)
	newFirst.Value = v
	newFirst.prev = nil
	newFirst.next = l.first

	if l.last == nil {
		l.last = newFirst
	}

	if l.first != nil {
		l.first.prev = newFirst
	}

	l.first = newFirst
}

func (l *List) Push(v interface{}) {
	var node = new(Node)
	node.Value = v.(int)
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
	var firstValue = l.first.Value
	l.first = l.first.next
	if l.first != nil {
		l.first.prev = nil
	} else {
		l.last = nil
	}

	return firstValue, nil
}

func (l *List) Pop() (interface{}, error) {
	var lastValue = l.last.Value

	fmt.Printf("just Popped %v\n", lastValue)
	l.last = l.last.prev
	if l.last != nil {
		l.last.next = nil
	} else {
		l.first = nil
	}

	return lastValue, nil
}

func (l *List) Reverse() {

	// There's a clever implementation where list tracks which direction
	// it traverses. Decided not to be clever and just reverse the list
	// dumb guard clause to handle empty and single element lists
	// TODO guard clause should go away once reverse is implemented
	if l.First() == nil {
		return
	}

	var forwardsNodes = new(Node)
	var savedFirst = forwardsNodes

	var backwardsNode = l.last
	for backwardsNode != nil {

		// TODO remove fmt.Printf("back value %v\n", backwardsNode.Value)
		forwardsNodes.Value = backwardsNode.Value
		var prevNode = forwardsNodes

		backwardsNode = backwardsNode.Prev()
		forwardsNodes = new(Node)
		forwardsNodes.prev = prevNode
		prevNode.next = forwardsNodes
	}

	l.first = savedFirst
	l.last = forwardsNodes.Prev()
	l.last.next = nil
}

func (l *List) First() *Node {
	return l.first
}

func (l *List) Last() *Node {
	return l.last
}
