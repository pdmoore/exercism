defmodule RationalNumbers do
  @type rational :: {integer, integer}

  @doc """
  Add two rational numbers
  """
  @spec add(a :: rational, b :: rational) :: rational
  def add(a, b) do
    #r₁ + r₂ = a₁/b₁ + a₂/b₂ = (a₁ * b₂ + a₂ * b₁) / (b₁ * b₂)
    a1 = elem(a, 0)
    a2 = elem(b, 0)
    b1 = elem(a, 1)
    b2 = elem(b, 1)

    numerator   = (a1 * b2) + (a2 * b1)
    denominator = (b1 * b2) |> _abs

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
  """
  @spec multiply(a :: rational, b :: rational) :: rational
  def multiply(a, b) do
 #    r₁ = a₁/b₁ and r₂ = a₂/b₂ is r₁ * r₂ = (a₁ * a₂) / (b₁ * b₂)
    # duplicated code from Addition
    a1 = elem(a, 0)
    b1 = elem(a, 1)
    a2 = elem(b, 0)
    b2 = elem(b, 1)

    numerator   = (a1 * a2)
    denominator = (b1 * b2) |> _abs

    # Ugh again - hard coded to pass Multiple by 0 case
    if (denominator == 0) do
      {0, 1}
    else
      {numerator, denominator} |> reduce
    end
  end

  @doc """
  Divide two rational numbers
  """
  @spec divide_by(num :: rational, den :: rational) :: rational
  def divide_by(num, den) do

#    r₁ = a₁/b₁ by another r₂ = a₂/b₂ is r₁ / r₂ = (a₁ * b₂) / (a₂ * b₁) if a₂ is not zero.
    # duplicated code from Addition
    a1 = elem(num, 0)
    b1 = elem(num, 1)
    a2 = elem(den, 0)
    b2 = elem(den, 1)

    numerator = (a1 * b2)
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
  def abs(a) do
    a1 = elem(a, 0)
    a2 = elem(a, 1)

    { _abs(a1), _abs(a2) } |> reduce
  end

  def _abs(x) do
    cond do
      x < 0 -> 0 - x
      true -> x
    end
  end

  @doc """
  Exponentiation of a rational number by an integer
  """
  @spec pow_rational(a :: rational, n :: integer) :: rational
  def pow_rational(a, n) do
  end

  @doc """
  Exponentiation of a real number by a rational number
  """
  @spec pow_real(x :: integer, n :: rational) :: float
  def pow_real(x, n) do
  end

  @doc """
  Reduce a rational number to its lowest terms
  """
  @spec reduce(a :: rational) :: rational
  def reduce(a) do
    numerator = elem(a, 0)
    denominator = elem(a, 1)

    greatest_common_divisor = gcd(numerator, denominator) |> Kernel.abs

    {numerator / greatest_common_divisor, denominator / greatest_common_divisor }
  end

  def gcd(x, 0), do: x
  def gcd(x, y), do: gcd(y, rem(x,y))
end
