using System;
using System.Collections.Generic;

public class CircularBuffer<T>
{
    private T[] _buffer2;
    private int _head;
    private int _tail;
    private int _capacity;
    private int _size;
    
    public CircularBuffer(int capacity)
    {
        _buffer2 = new T[capacity];
        _head = 0;
        _tail = 0;
        _capacity = capacity;
        _size = 0;
    }

    public T Read()
    {
        if (_size == 0)
        {
            throw new InvalidOperationException();
        }

        T result = _buffer2[_tail];
        _buffer2[_tail] = default(T);

        _tail++;
        _size--;
        
        return result;
    }

    public void Write(T value)
    {
        if (_size == _capacity)
        {
            throw new InvalidOperationException();
        }
        
        _buffer2[_head] = value;
        _head++;
        _size++;
        if (_head == _capacity)
        {
            _head = 0;
        }
    }

    public void Overwrite(T value)
    {
        throw new NotImplementedException("You need to implement this function.");
    }

    public void Clear()
    {
        throw new NotImplementedException("You need to implement this function.");
    }
}