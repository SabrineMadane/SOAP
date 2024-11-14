
package proxy;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;
@WebService(name = "BanqueService", targetNamespace = "http://ws.emsi.ma/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BanqueService {


    /**
     *
     * @param montant
     * @return
     *     returns double
     */
    @WebMethod(operationName = "Convert")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Convert", targetNamespace = "http://ws.emsi.ma/", className = "proxy.Convert")
    @ResponseWrapper(localName = "ConvertResponse", targetNamespace = "http://ws.emsi.ma/", className = "proxy.ConvertResponse")
    @Action(input = "http://ws.emsi.ma/BanqueService/ConvertRequest", output = "http://ws.emsi.ma/BanqueService/ConvertResponse")
    public double convert(
        @WebParam(name = "montant", targetNamespace = "")
        double montant);

    /**
     *
     * @param code
     * @return
     *     returns proxy.Compte
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompte", targetNamespace = "http://ws.emsi.ma/", className = "proxy.GetCompte")
    @ResponseWrapper(localName = "getCompteResponse", targetNamespace = "http://ws.emsi.ma/", className = "proxy.GetCompteResponse")
    @Action(input = "http://ws.emsi.ma/BanqueService/getCompteRequest", output = "http://ws.emsi.ma/BanqueService/getCompteResponse")
    public Compte getCompte(
        @WebParam(name = "code", targetNamespace = "")
        int code);

    /**
     *
     * @return
     *     returns java.util.List<proxy.Compte>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listComptes", targetNamespace = "http://ws.emsi.ma/", className = "proxy.ListComptes")
    @ResponseWrapper(localName = "listComptesResponse", targetNamespace = "http://ws.emsi.ma/", className = "proxy.ListComptesResponse")
    @Action(input = "http://ws.emsi.ma/BanqueService/listComptesRequest", output = "http://ws.emsi.ma/BanqueService/listComptesResponse")
    public List<Compte> listComptes();

}
