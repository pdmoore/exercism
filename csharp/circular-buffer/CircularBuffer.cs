using System;

public class CircularBuffer<T>
{
    private T _value;

    public CircularBuffer(int capacity)
    {
        _value = default(T);
    }

    public T Read()
    {
        if (_value.Equals(default(T)))
        {
            throw new InvalidOperationException();
        }

        T result = _value;
        _value = default(T);
        return result;
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