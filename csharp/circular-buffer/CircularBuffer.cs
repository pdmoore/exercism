using System;

public class CircularBuffer<T>
{
    //TODO - need all these?
    //TODO - compose Read and Write
    
    private readonly T[] _buffer2;
    private readonly int _capacity;
    
    private int _head;
    private int _tail;
    private int _size;
    
    public CircularBuffer(int capacity)
    {
        _buffer2 = new T[capacity];
        _capacity = capacity;
        
        ResetContents();
    }

    public T Read()
    {
        if (_size == 0)
        {
            throw new InvalidOperationException();
        }

        T result = _buffer2[_tail];
        _buffer2[_tail] = default(T);

        
        _tail = IncrementOrWrap(_tail);

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
        _size++;

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
        _buffer2[_tail] = value;
        _tail = IncrementOrWrap(_tail);
    }

    public void Clear() => ResetContents();

    private void ResetContents() {
        _head = 0;
        _tail = 0;
        _size = 0;
    }
}