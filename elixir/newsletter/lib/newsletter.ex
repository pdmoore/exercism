defmodule Newsletter do
  def read_emails(path) do
    file_contents = File.read!(path)
    x = String.trim(file_contents)
    if String.length(x) == 0 do
      []
      else
    String.split(x, "\n")
    end
  end

  def open_log(path) do
    # Please implement the open_log/1 function
  end

  def log_sent_email(pid, email) do
    # Please implement the log_sent_email/2 function
  end

  def close_log(pid) do
    File.close(pid)
  end

  def send_newsletter(emails_path, log_path, send_fun) do
    # Please implement the send_newsletter/3 function
  end
end
