import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Syp on 2018/2/1.
 */
public class Mytomcat {
    private int port = 8080;
    private Map<String,String> urlServletMap = new HashMap<>();

    public Mytomcat(int port) {
        this.port = port;
    }
    public void start(){
        initServletMapping();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("my tomcat is start ......");

            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                //请求fenfa
                dispatch(myRequest,myResponse);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void initServletMapping(){
        for(ServletMapping servletMapping : ServletMappingConfig.servletMappings){
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    public void dispatch(MyRequest myRequest,MyResponse myResponse){
        String clazz = urlServletMap.get(myRequest.getUrl());
        //反射
        try {
            Class<MyServlet> servletClass = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = servletClass.newInstance();

            myServlet.service(myRequest,myResponse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        new Mytomcat(8080).start();
    }
}
