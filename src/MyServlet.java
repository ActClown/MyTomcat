/**
 * Created by Syp on 2018/2/1.
 */
public abstract class MyServlet {
    public abstract void doGet(MyRequest myRequest,MyResponse myResponse);
    public abstract void doPost(MyRequest myRequest,MyResponse myResponse);

    public void service (MyRequest myRequest,MyResponse myResponse){
        if(myRequest.getMethod().equalsIgnoreCase("get")){
            doGet(myRequest,myResponse);
        }else {
            doPost(myRequest,myResponse);
        }
    }
}
