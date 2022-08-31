defmodule Newsletter do
  def read_emails(path) do
    File.read!(path)
      |> String.trim
      |> process_emails
  end

  def process_emails(""), do: []
  def process_emails(emails), do: String.split(emails, "\n")

  def open_log(path) do
    File.open!(path, [:write])
  end

  def log_sent_email(pid, email) do
    IO.write(pid, email)
    IO.write(pid, "\n")
  end

  def close_log(pid) do
    File.close(pid)
  end

  def send_newsletter(emails_path, log_path, send_fun) do
    # Please implement the send_newsletter/3 function
  end
end
