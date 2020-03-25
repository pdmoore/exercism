using System;

public class CircularBuffer<T>
{
    private readonly T[] _buffer;
    private readonly int _capacity;
    
    private int _head;
    private int _tail;
    private int _count;
    
    public CircularBuffer(int capacity)
    {
        _buffer = new T[capacity];
        _capacity = capacity;
    }

    public T Read()
    {
        if (_count == 0)
        {
            throw new InvalidOperationException();
        }

        _count--;

        T result = _buffer[_tail];
        
        _tail = IncrementOrWrap(_tail);
        
        return result;
    }

    public void Write(T value)
    {
        if (_count == _capacity)
        {
            throw new InvalidOperationException();
        }
        
        _count++;

        _buffer[_head] = value;

        _head = IncrementOrWrap(_head);
    }


    public void Overwrite(T value)
    {
        _buffer[_tail] = value;
        _tail = IncrementOrWrap(_tail);
    }

    public void Clear()
    {
        _head = 0;
        _tail = 0;
        _count = 0;
    }

    private int IncrementOrWrap(int index)
    {
        index++;
        if (index == _capacity)
        {
            index = 0;
        }

        return index;
    }
}