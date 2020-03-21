using System;

public class CircularBuffer<T>
{
    private int _capacity;
    private T _value;

    public CircularBuffer(int capacity)
    {
        _capacity = capacity;
        _value = default(T);
    }

    public T Read()
    {
        if (_value.Equals(default(T)))
        {
            throw new InvalidOperationException();
        }

        return _value;
    }

    public void Write(T value)
    {
        _value = value;
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