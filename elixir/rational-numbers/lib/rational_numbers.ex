defmodule RationalNumbers do
  @type rational :: {integer, integer}

  @doc """
  Add two rational numbers
  r₁ + r₂ = a₁/b₁ + a₂/b₂ = (a₁ * b₂ + a₂ * b₁) / (b₁ * b₂)
  """
  @spec add(a :: rational, b :: rational) :: rational
  def add({a1, b1}, {a2, b2}) do
    numerator   = (a1 * b2) + (a2 * b1)
    denominator = (b1 * b2)

    { numerator, denominator } |> reduce
  end

  @doc """
  Subtract two rational numbers
  """
  @spec subtract(a :: rational, b :: rational) :: rational
  def subtract(a, b) do
    # can this be refactored?
    negate_b = {-1 * elem(b, 0), elem(b, 1)}
    add(a, negate_b)
  end

  @doc """
  Multiply two rational numbers
  r₁ = a₁/b₁ and r₂ = a₂/b₂ is r₁ * r₂ = (a₁ * a₂) / (b₁ * b₂)
  """
  @spec multiply(a :: rational, b :: rational) :: rational
  def multiply({a1, b1}, {a2, b2}) do
    numerator   = (a1 * a2)
    denominator = (b1 * b2)

    { numerator, denominator } |> reduce
  end

  @doc """
  Divide two rational numbers
  r₁ = a₁/b₁ by another r₂ = a₂/b₂ is r₁ / r₂ = (a₁ * b₂) / (a₂ * b₁) if a₂ is not zero.
  """
  @spec divide_by(num :: rational, den :: rational) :: rational
  def divide_by({a1, b1}, {a2, b2}) do
    numerator   = (a1 * b2)
    denominator = (a2 * b1)

    if (denominator < 0) do
      { 0 - numerator, _abs(denominator)}
    else
      {numerator, denominator}
    end
  end

  @doc """
  Absolute value of a rational number
  """
  @spec abs(a :: rational) :: rational
  def abs({a1, a2}) do
    { _abs(a1), _abs(a2) } |> reduce
  end

  defp _abs(x) when x < 0, do: 0 - x
  defp _abs(x), do: x

  @doc """
  Exponentiation of a rational number by an integer
  r^n = (a^n)/(b^n)
  r = a/b to a negative integer power n is r^n = (b^m)/(a^m), where m = |n|
  """
  @spec pow_rational(a :: rational, n :: integer) :: rational
  def pow_rational(_, n) when n == 0, do: {1, 1}
  def pow_rational({a1, a2}, n) when n > 0 do
    { pow(a1, n), pow(a2, n) }
  end
  def pow_rational(a, n) do
    a1 = a |> elem(0)
    a2 = a |> elem(1)

    m = _abs(n)

    { pow(a2, m), pow(a1, m) } |> reduce
  end

  defp pow(x, n) when n == 1, do: x
  defp pow(x, n), do: x * pow(x, n - 1)

  @doc """
  Exponentiation of a real number by a rational number
  """
  @spec pow_real(x :: integer, n :: rational) :: float
  def pow_real(_, n) when elem(n, 0) == 0, do: 1.0
  def pow_real(x, n) when elem(n, 0) < 0 do
    b = n |> elem(1)

    1 / (x**(1/b))
  end

  def pow_real(x, n) do
    a = n |> elem(0)
    b = n |> elem(1)

    pow = pow(x, a)
    pow**(1/b)
  end

  @doc """
  Reduce a rational number to its lowest terms
  """
  @spec reduce(a :: rational) :: rational
  def reduce(a) do
    numerator   = a |> elem(0)
    denominator = a |> elem(1)

    gcd = greatest_common_divisor(numerator, denominator) |> Kernel.abs

    cond do
      denominator < 0 ->
        { -1 * (numerator / gcd), -1 * (denominator / gcd) }
      true ->
        {numerator / gcd, denominator / gcd }
    end
  end

  defp greatest_common_divisor(x, 0), do: x
  defp greatest_common_divisor(x, y), do: greatest_common_divisor(y, rem(x,y))
end
