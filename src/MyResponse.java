import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Syp on 2018/2/1.
 */
public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content)throws IOException{
        //根据HTTP响应去解析
        StringBuffer buffer = new StringBuffer();
        buffer.append("HTTP/1.1 200 OK\n")
            .append("Content-Type: text/html\n")
            .append("\r\n")
            .append("<html><body>")
            .append(content)
            .append("<body><html>");

        outputStream.write(buffer.toString().getBytes());
        outputStream.close();
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
