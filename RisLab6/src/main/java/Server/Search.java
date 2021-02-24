package Server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Search {
    @WebMethod
    public String searchFIO(String name, String surname);
    @WebMethod
    public String searchPost(String post);
}

