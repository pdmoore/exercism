defmodule ResistorColorTrio do
  @color_value %{
    black:  0,
    brown:  1,
    red:    2,
    orange: 3,
    yellow: 4,
    green:  5,
    blue:   6,
    violet: 7,
    grey:   8,
    white:  9
  }

  @doc """
  Calculate the resistance value in ohms from resistor colors
  """
  @spec label(colors :: [atom]) :: {number, :ohms | :kiloohms | :megaohms | :gigaohms}
  def label([band_1, band_2, band_3 | _]) do
    tens = @color_value[band_1] * 10
    ones = @color_value[band_2]

    ohms = tens + ones
    case band_3 do
      :red    -> {ohms / 10, :kiloohms}
      :orange -> {ohms, :kiloohms}
      :yellow -> {ohms * 10, :kiloohms}
      :blue   -> {ohms, :megaohms}
      :white  -> {ohms, :gigaohms}
      _ ->  {ohms * trunc(:math.pow(10, @color_value[band_3])), :ohms}
    end

  end
end
