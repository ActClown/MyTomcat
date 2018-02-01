import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Syp on 2018/2/1.
 */
public class MyRequest {

    private String url;
    private String method;

    public MyRequest (InputStream inputStream)throws IOException{
        String httpRequest = "";
        byte [] httpRequestBytes = new byte[1024];
        Integer len = 0;
        if((len = inputStream.read(httpRequestBytes))>0){
            httpRequest = new String(httpRequestBytes,0,len);
        }

        //通过解析HTTP协议,获得请求头、方法、url
        System.out.println("httpRequest:\n"+httpRequest);

        String httpHeader = httpRequest.split("\n")[0];

        url = httpHeader.split("\\s")[1];
        System.out.println("url:\n"+url);

        method = httpHeader.split("\\s")[0];
        System.out.println(this);

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
