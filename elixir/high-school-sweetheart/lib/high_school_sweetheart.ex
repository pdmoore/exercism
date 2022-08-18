defmodule HighSchoolSweetheart do
  def first_letter(name) do
    name |> String.trim |> String.first
  end

  def initial(name) do
    name |> first_letter |> String.upcase |> Kernel.<>(".")
  end

  def initials(full_name) do
    tokens = full_name |> String.split
    first_initial = Enum.at(tokens, 0) |> initial
    last_initial = Enum.at(tokens, 1) |> initial
    first_initial <> " " <> last_initial
  end

  def pair(full_name1, full_name2) do
    left = initials(full_name1)
    right = initials(full_name2)
    plussed = "**     " <> left <> "  +  " <> right <> "     **\n"
    """
         ******       ******
       **      **   **      **
     **         ** **         **
    **            *            **
    **                         **
    """
    <> plussed <>
    """
     **                       **
       **                   **
         **               **
           **           **
             **       **
               **   **
                 ***
                  *
    """
  end
end
