import java.util.ArrayList;
import java.util.List;

/**
 * Created by Syp on 2018/2/1.
 */
public class ServletMappingConfig {
    public static List<ServletMapping>  servletMappings = new ArrayList<>();
    static {
        servletMappings.add(new ServletMapping("findGirl","/girl","FindGirlMyservlet"));
    }
}
