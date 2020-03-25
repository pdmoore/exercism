using System;

public class CircularBuffer<T>
{
    //TODO - compose Read and Write
    
    private readonly T[] _buffer;
    private readonly int _capacity;
    
    private int _head;
    private int _tail;
    private int _count;
    
    public CircularBuffer(int capacity)
    {
        _buffer = new T[capacity];
        _capacity = capacity;
        
        ResetContents();
    }

    public T Read()
    {
        if (_count == 0)
        {
            throw new InvalidOperationException();
        }

        T result = _buffer[_tail];
        _buffer[_tail] = default(T);

        
        _tail = IncrementOrWrap(_tail);

        _count--;
        
        return result;
    }

    public void Write(T value)
    {
        if (_count == _capacity)
        {
            throw new InvalidOperationException();
        }
        
        _buffer[_head] = value;
        _count++;

        _head = IncrementOrWrap(_head);
    }

    private int IncrementOrWrap(int index)
    {
        index++;
        if (index == _capacity) {
            index = 0;
        }

        return index;
    }


    public void Overwrite(T value)
    {
        _buffer[_tail] = value;
        _tail = IncrementOrWrap(_tail);
    }

    public void Clear() => ResetContents();

    private void ResetContents() {
        _head = 0;
        _tail = 0;
        _count = 0;
    }
}