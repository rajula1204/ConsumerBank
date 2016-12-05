package net.webservicex;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2016-12-05T20:19:35.402+05:30
 * Generated source version: 3.0.3
 * 
 */
@WebService(targetNamespace = "http://www.webserviceX.NET/", name = "MortgageHttpPost")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface MortgageHttpPost {

    /**
     * Use this Web service to figure out your monthly mortgage payment
     * 			
     */
    @WebResult(name = "MortgageResults", targetNamespace = "http://www.webserviceX.NET/", partName = "Body")
    @WebMethod(operationName = "GetMortgagePayment")
    public MortgageResults getMortgagePayment(
        @WebParam(partName = "Years", name = "Years", targetNamespace = "")
        java.lang.String years,
        @WebParam(partName = "Interest", name = "Interest", targetNamespace = "")
        java.lang.String interest,
        @WebParam(partName = "LoanAmount", name = "LoanAmount", targetNamespace = "")
        java.lang.String loanAmount,
        @WebParam(partName = "AnnualTax", name = "AnnualTax", targetNamespace = "")
        java.lang.String annualTax,
        @WebParam(partName = "AnnualInsurance", name = "AnnualInsurance", targetNamespace = "")
        java.lang.String annualInsurance
    );
}
