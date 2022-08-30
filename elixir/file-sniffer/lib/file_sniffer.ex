defmodule FileSniffer do
  def type_from_extension(extension) when extension == "bmp", do: "image/bmp"
  def type_from_extension(extension) when extension == "gif", do: "image/gif"
  def type_from_extension(extension) when extension == "jpg", do: "image/jpg"
  def type_from_extension(extension) when extension == "png", do: "image/png"
  def type_from_extension(extension) when extension == "exe", do: "application/octet-stream"
  def type_from_extension(extension) do
  end

  def type_from_binary(file_binary) do
    # Please implement the type_from_binary/1 function
  end

  def verify(file_binary, extension) do
    # Please implement the verify/2 function
  end
end
