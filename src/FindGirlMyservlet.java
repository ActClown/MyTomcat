import java.io.IOException;

/**
 * Created by Syp on 2018/2/1.
 */
public class FindGirlMyservlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("you are a beautiful girl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("you are a beautiful girl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
