package icbs.tellering

import icbs.admin.UserMaster
import grails.transaction.Transactional
import javax.xml.soap.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import icbs.tellering.SssConfig
import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.sql.Sql
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import icbs.tellering.TxnFile
@Transactional
class SSSOnlineService {
   
    static String sssbRRNumber = "";
    static String ssstokenID = "";
    static String sssPrnNumber = "";
    static String sssMemberSSSNumber = "";
    static String sssMemberDateOfbirth = "";
    static String sssBankPPTYP = "";
    static Date dateOfBirth;
    static String sssActionMethod = "";
    static String sssMemType = "";
    static String sssTapid = "";
    static String sssFaid = "";
    static String ssstransactionAmount = "";
    static String sssXMLReturnvalue = "";
    static String transactionNumber = "";
    private static final DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    def collectDataAjax(params,String txnNummber){
         println("sss transaction params: "+params)
         String sssMethods =  params.wsdlMethod.toString()
         transactionNumber = txnNummber.toString()
         sssBankPPTYP = SssConfig.findByParamCode("GEN.10261").paramValue.toString()
         println("transactionNumber: "+transactionNumber)
                /*
            The example below requests from the Web Service at:
             http://www.webservicex.net/uszip.asmx?op=GetInfoByCity


            To call other WS, change the parameters below, which are:
             - the SOAP Endpoint URL (that is, where the service is responding from)
             - the SOAP Action

            Also change the contents of the method createSoapEnvelope() in this class. It constructs
             the inner part of the SOAP envelope that is actually sent.
         */

        String soapEndpointUrl = "";
        String soapAction = "";
        
        
        
        if(sssMethods == "loadEmployerStatus" || sssMethods == "submitPaidBRNum"){
            
            sssbRRNumber = params.ssstxnBillRef.toString()
            ssstokenID = SssConfig.findByParamCode("GEN.10253").paramValue.toString()
            
            soapEndpointUrl = SssConfig.findByParamCode("GEN.10254").paramValue.toString()
            soapAction = SssConfig.findByParamCode("GEN.10255").paramValue.toString()
            println("soapEndpointUrl: "+soapEndpointUrl)
            println("soapAction: "+soapAction)
        } else if (sssMethods == "inquireIndividualSSnum") {
            soapEndpointUrl = SssConfig.findByParamCode("GEN.10258").paramValue.toString()
            soapAction = SssConfig.findByParamCode("GEN.10259").paramValue.toString()
            ssstokenID = SssConfig.findByParamCode("GEN.10257").paramValue.toString()
            sssMemberSSSNumber = params.sssNumber.toString()
            sssMemberDateOfbirth = params.indidobBirth.toString()
           
            // inquire PRN using SSS number and DOB
            // note that DOB must be MM/DD/YYYY
        } else if (sssMethods == "loadIndividualPRNChange") {
            soapEndpointUrl = SssConfig.findByParamCode("GEN.10258").paramValue.toString()
            soapAction = SssConfig.findByParamCode("GEN.10259").paramValue.toString()
            ssstokenID = SssConfig.findByParamCode("GEN.10257").paramValue.toString()
            params.totalAmt = params.totalAmt.replaceAll(",","")
            sssMemberSSSNumber = params.sssNumber.toString()
            println("params.totalAmt: "+params.totalAmt)
            ssstransactionAmount = params.totalAmt.toString()
            sssMemType = params.membershipType.toString()
            sssTapid = params.tapId.toString()
            sssFaid = params.fapId.toString()
            
            // request for new PRN
            
        } else if (sssMethods == "inquireIndividualPRN") {
            soapEndpointUrl = SssConfig.findByParamCode("GEN.10258").paramValue.toString()
            soapAction = SssConfig.findByParamCode("GEN.10259").paramValue.toString()
            ssstokenID = SssConfig.findByParamCode("GEN.10257").paramValue.toString()
            sssPrnNumber = params.sssPrnNumber.toString()
        }
        else {
            //submitPaidIPRNum
            println("==================== submit submitPaidIPRNum")
            soapEndpointUrl = SssConfig.findByParamCode("GEN.10258").paramValue.toString()
            soapAction = SssConfig.findByParamCode("GEN.10259").paramValue.toString()
            ssstokenID = SssConfig.findByParamCode("GEN.10257").paramValue.toString()
            sssPrnNumber = params.iprnum.toString()
        }
        
        callSoapWebService(soapEndpointUrl, soapAction, sssMethods);
        println("RETURNNNNNNN: "+sssXMLReturnvalue)
        return sssXMLReturnvalue
        
    }
    public static void createSoapEnvelope(SOAPMessage soapMessage, String soapMethod) throws SOAPException {
       
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "ns1";
        String myNamespaceURI = ""
        
        
        if(soapMethod == "loadEmployerStatus" || soapMethod == "submitPaidBRNum"){
            myNamespaceURI = SssConfig.findByParamCode("GEN.10256").paramValue.toString()
        }
        else{
            myNamespaceURI = SssConfig.findByParamCode("GEN.10260").paramValue.toString()
        }     
        println("myNamespaceURI: "+myNamespaceURI)
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:GetInfoByCity>
                        <myNamespace:USCity>New York</myNamespace:USCity>
                    </myNamespace:GetInfoByCity>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */
        println "second " + soapMethod
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement(soapMethod, myNamespace);
        // SOAP Body
        if(soapMethod == "inquireIndividualPRN"){
            println("===========   inquireIndividualPRN  =========== ")
             // element Arg0 is for token
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg0");
            soapBodyElem1.addTextNode(ssstokenID);
            // element Arg1 is for PRN
            SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("arg1");
            soapBodyElem2.addTextNode(sssPrnNumber);   
            
        }
       
        if(soapMethod == "inquireIndividualSSnum"){
            println("ssstokenID: "+ssstokenID)
            println("sssMemberSSSNumber: "+sssMemberSSSNumber)
            println("sssMemberDateOfbirth: "+sssMemberDateOfbirth)
            // element Arg0 is for Token ID
            println("===========   inquireIndividualSSnum  =========== ")
            SOAPElement soapBodyElem0 = soapBodyElem.addChildElement("arg0");
            soapBodyElem0.addTextNode(ssstokenID);
            // element Arg1 is for SSS Number
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg1");
            soapBodyElem1.addTextNode(sssMemberSSSNumber);
            // element Arg1 is for Date Of Birth
            SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("arg2");
            soapBodyElem2.addTextNode(sssMemberDateOfbirth);
        }
        if(soapMethod == "loadEmployerStatus"){
            println("===========   loadEmployerStatus  =========== ")
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("BillRefNo");
            soapBodyElem1.addTextNode(sssbRRNumber);
            SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("TokenID");
            soapBodyElem2.addTextNode(ssstokenID); 
            
        
        }
        if(soapMethod == "submitPaidBRNum"){
             println("===========   submitPaidBRNum  =========== ")
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("BillRefNo");
            println("sssbRRNumber: "+sssbRRNumber)
            
            soapBodyElem1.addTextNode(sssbRRNumber);
            SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("TokenID");
            println("ssstokenID: "+ssstokenID)
            soapBodyElem2.addTextNode(ssstokenID);
            SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("payTimeStamp");
            Date date = new Date();
            println("SDF : "+date)
            println("SDF new format: "+sdf.format(date))
            soapBodyElem3.addTextNode(sdf.format(date));
            println("END FUNCTION CREATE SOAP ENVELOPE")
        }
        
        if(soapMethod == "submitPaidIPRNum"){
            println("========  SUBMITPAID IPR NUMBER ========")
            println("sssPrnNumber: "+sssPrnNumber)
            println("transactionNumber: "+transactionNumber)
            println("ssstokenID: "+ssstokenID)
            // element Arg0 is for Payment Reference Number
            SOAPElement soapBodyElem0 = soapBodyElem.addChildElement("arg0");
            soapBodyElem0.addTextNode(sssPrnNumber);
            
            // element Arg1 is for payTimeStamp following pattern MM/dd/YYYY HH24:MM:SS
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg1");
            Date date = new Date();
            println("SDF : "+date)
            println("SDF new format: "+sdf.format(date))
            soapBodyElem1.addTextNode(sdf.format(date));
            
            // element Arg2 is for Payment Transaction Number 
            SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("arg2");
            soapBodyElem2.addTextNode(transactionNumber);
            
            // element Arg3 is for Partner PAyment Type / Code (PTTYP)
            SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("arg3");
            soapBodyElem3.addTextNode(sssBankPPTYP);
            
            // element Arg4 is for TOKEN ID
            SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("arg4");
            soapBodyElem4.addTextNode(ssstokenID);
            
           
            
            println("END FUNCTION CREATE SOAP ENVELOPE")
        }
        if(soapMethod == "loadIndividualPRNChange"){
            //ssstokenID/sssMemberSSSNumber/ssstransactionAmount/sssMemType/sssTapid/sssFaid
            // element Arg 0 for Token ID
            SOAPElement soapBodyElem0 = soapBodyElem.addChildElement("arg0");
            soapBodyElem0.addTextNode(ssstokenID);
            
            // element Arg1 for Membership Type
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("arg1");
            soapBodyElem1.addTextNode(sssMemType);
            
            // element Arg2 for Membership SSS Number
            SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("arg2");
            soapBodyElem2.addTextNode(sssMemberSSSNumber);
            
            // element Arg3 is for Transaction Amount
            SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("arg3");
            soapBodyElem3.addTextNode(ssstransactionAmount);
            
            // element Arg4 is for FapId (Applicable Month Start) pattern MMYYYY
            SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("arg4");
            soapBodyElem4.addTextNode(sssFaid);
            
            // element Arg5 is for TapId (Applicable Month end) pattern MMYYYY
            SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("arg5");
            soapBodyElem5.addTextNode(sssTapid);
            println("ssstokenID: "+ssstokenID)
            println("sssMemType: "+sssMemType)
            println("sssMemberSSSNumber: "+sssMemberSSSNumber)
            println("ssstransactionAmount: "+ssstransactionAmount)
            println("sssFaid: "+sssFaid)
            println("sssTapid: "+sssTapid)
            
        }
        
    }

    public static void callSoapWebService(String soapEndpointUrl, String soapAction,  String sssMethods) {
        try {
            println(" ***************** CALLS SOAP WEB SERVICE **********************")
            println soapEndpointUrl
            println soapAction
            println sssMethods
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            println "soap before 4th"
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction,sssMethods), soapEndpointUrl);
            SOAPBody soapBody = soapResponse.getSOAPBody();
            String replyMesg = ""
            // Print the SOAP Response
            //===========================================
            if(sssMethods == "inquireIndividualPRN"){
                NodeList eename = soapBody.getElementsByTagName("eename");
                        NodeList eenum = soapBody.getElementsByTagName("eenum");
                        NodeList fapld = soapBody.getElementsByTagName("fapld");
                        NodeList iprnum = soapBody.getElementsByTagName("iprnum");
                        NodeList repcd = soapBody.getElementsByTagName("repcd");
                        NodeList repdt = soapBody.getElementsByTagName("repdt");
                        NodeList tapld = soapBody.getElementsByTagName("tapld");
                        NodeList tsamt = soapBody.getElementsByTagName("tsamt");


                       // declaration of string container of each nodes
                            String streename = null;
                            String streenum = null;
                            String strfapld = null;
                            String striprnum = null;
                            String strrepcd = null;
                            String strrepdt = null;
                            String strtapld = null;
                            String strtsamt = null;
                        //==============================================

                                    // set values to get the name inside the xml data code
                        // By CRD TEAM Batch TEAM POGI
                            Node nodeEename = eename.item(0);
                            Node nodeEenum = eenum.item(0);
                            Node nodeFapld = fapld.item(0);
                            Node nodeIprnum = iprnum.item(0);
                            Node nodeRepcd = repcd.item(0);
                            Node nodeRepdt = repdt.item(0);
                            Node nodeTapld = tapld.item(0);
                            Node nodeTsamt = tsamt.item(0);

                        //======================================================
                        streename = nodeEename != null ? nodeEename.getTextContent() : "";
                        streenum = nodeEenum != null ? nodeEenum.getTextContent() : "";
                        strfapld = nodeFapld != null ? nodeFapld.getTextContent() : "";
                        striprnum = nodeIprnum != null ? nodeIprnum.getTextContent() : "";
                        strrepcd = nodeRepcd != null ? nodeRepcd.getTextContent() : "";
                        strrepdt = nodeRepdt != null ? nodeRepdt.getTextContent() : "";
                        strtapld = nodeTapld != null ? nodeTapld.getTextContent() : "";
                        strtsamt = nodeTsamt != null ? nodeTsamt.getTextContent() : "";
                        if(strrepcd == "1" || strrepcd.equalsIgnoreCase("1")){
                            println("================================")
                            println("I-PRN Not Found in Master File")
                            replyMesg = "I-PRN Not Found in Master File !"; 
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strrepcd == "2" || strrepcd.equalsIgnoreCase("2")){
                            println("================================")
                            println("I-PRN Already Paid")   
                            replyMesg = "I-PRN Already Paid !"
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strrepcd == "98" || strrepcd.equalsIgnoreCase("98")){
                            println("================================")
                            println("Authentication Error") 
                             replyMesg = "Authentication Error!"
                             sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strrepcd == "99" || strrepcd.equalsIgnoreCase("99")){
                            println("================================")
                            println("Internal Service Error")
                            replyMesg = "Internal Service Error!"
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else{
                         println("===   *****  FOUND IN MASTER FILE ******* =======")
                            println("SSS EENAME: "+streename)   
                            println("SSS EENUM: "+streenum)   
                            println("SSSFAPID: "+strfapld) 
                            println("SSS PRN Number: "+striprnum) 
                            println("SSS REPLY CODE: "+strrepcd)
                            println("SSS REPLY DATE: "+strrepdt)
                            println("SSS TAPID: "+strtapld)
                            println("SSS Transaction Amount: "+strtsamt)
                            replyMesg = "I-PRN Successfully found in the Master File |success|alert"
                            
                            println("==================================================")
                            sssXMLReturnvalue =""            
                            sssXMLReturnvalue = streename + '@@#' +streenum + '@@#' +strfapld + '@@#' +striprnum + '@@#' +strrepcd + '@@#' +strrepdt + '@@#' +strtapld + '@@#' +strtsamt + '@@#' + replyMesg + '@@#'
                        }
                System.out.println("inquireIndividualPRN : Response SOAP Message:");
                soapResponse.writeTo(System.out);
                System.out.println();          
                
            }
            
            if(sssMethods == "inquireIndividualSSnum"){
                // find your node based on tag name
                        NodeList eename = soapBody.getElementsByTagName("eename");
                        NodeList eenum = soapBody.getElementsByTagName("eenum");
                        NodeList fapld = soapBody.getElementsByTagName("fapld");
                        NodeList iprnum = soapBody.getElementsByTagName("iprnum");
                        NodeList repcd = soapBody.getElementsByTagName("repcd");
                        NodeList repdt = soapBody.getElementsByTagName("repdt");
                        NodeList tapld = soapBody.getElementsByTagName("tapld");
                        NodeList tsamt = soapBody.getElementsByTagName("tsamt");


                       // declaration of string container of each nodes
                            String streename = null;
                            String streenum = null;
                            String strfapld = null;
                            String striprnum = null;
                            String strrepcd = null;
                            String strrepdt = null;
                            String strtapld = null;
                            String strtsamt = null;
                        //==============================================

                                    // set values to get the name inside the xml data code
                        // By CRD TEAM Batch TEAM POGI
                            Node nodeEename = eename.item(0);
                            Node nodeEenum = eenum.item(0);
                            Node nodeFapld = fapld.item(0);
                            Node nodeIprnum = iprnum.item(0);
                            Node nodeRepcd = repcd.item(0);
                            Node nodeRepdt = repdt.item(0);
                            Node nodeTapld = tapld.item(0);
                            Node nodeTsamt = tsamt.item(0);

                        //======================================================
                        streename = nodeEename != null ? nodeEename.getTextContent() : "";
                        streenum = nodeEenum != null ? nodeEenum.getTextContent() : "";
                        strfapld = nodeFapld != null ? nodeFapld.getTextContent() : "";
                        striprnum = nodeIprnum != null ? nodeIprnum.getTextContent() : "";
                        strrepcd = nodeRepcd != null ? nodeRepcd.getTextContent() : "";
                        strrepdt = nodeRepdt != null ? nodeRepdt.getTextContent() : "";
                        strtapld = nodeTapld != null ? nodeTapld.getTextContent() : "";
                        strtsamt = nodeTsamt != null ? nodeTsamt.getTextContent() : "";
                        if(strrepcd == "1" || strrepcd.equalsIgnoreCase("1")){
                            println("================================")
                            println("I-PRN Not Found in Master File")
                            replyMesg = "I-PRN Not Found in Master File !"; 
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strrepcd == "2" || strrepcd.equalsIgnoreCase("2")){
                            println("================================")
                            println("I-PRN Already Paid")   
                            replyMesg = "I-PRN Already Paid !"
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strrepcd == "98" || strrepcd.equalsIgnoreCase("98")){
                            println("================================")
                            println("Authentication Error") 
                             replyMesg = "Authentication Error!"
                             sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strrepcd == "99" || strrepcd.equalsIgnoreCase("99")){
                            println("================================")
                            println("Internal Service Error")
                            replyMesg = "Internal Service Error!"
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else{
                         println("===   *****  FOUND IN MASTER FILE ******* =======")
                            println("SSS EENAME: "+streename)   
                            println("SSS EENUM: "+streenum)   
                            println("SSSFAPID: "+strfapld) 
                            println("SSS PRN Number: "+striprnum) 
                            println("SSS REPLY CODE: "+strrepcd)
                            println("SSS REPLY DATE: "+strrepdt)
                            println("SSS TAPID: "+strtapld)
                            println("SSS Transaction Amount: "+strtsamt)
                            replyMesg = "I-PRN Successfully found in the Master File |success|alert"
                            
                            println("==================================================")
                            sssXMLReturnvalue =""            
                            sssXMLReturnvalue = streename + '@@#' +streenum + '@@#' +strfapld + '@@#' +striprnum + '@@#' +strrepcd + '@@#' +strrepdt + '@@#' +strtapld + '@@#' +strtsamt + '@@#' + replyMesg + '@@#'
                        }
                System.out.println("inquireIndividualSSnum : Response SOAP Message:");
                
                soapResponse.writeTo(System.out);
                System.out.println();
                
            }
            if(sssMethods == "submitPaidBRNum"){
                System.out.println("submitPaidBRNum : Response SOAP Message:");
                NodeList replyCode = soapBody.getElementsByTagName("replyCode");
                Node nodeReplyCode = replyCode.item(0);
                String strReplyCode = null;
                strReplyCode = nodeReplyCode != null ? nodeReplyCode.getTextContent() : "";
                if(strReplyCode == "1" || strReplyCode.equalsIgnoreCase("1")){
                            println("================================")
                            println("E-PRN not found in Masterfile")
                            replyMesg = "E-PRN not found in Masterfile ! |info|alert"; 
                            println("================================")
                        }else if(strReplyCode == "2" || strReplyCode.equalsIgnoreCase("2")){
                            println("================================")
                            println("E-PRN is already paid")   
                            replyMesg = "E-PRN is already paid! |info|alert"
                            println("================================")
                        }else if(strReplyCode == "98" || strReplyCode.equalsIgnoreCase("98")){
                            println("================================")
                            println("Authentication Error") 
                             replyMesg = "Authentication Error! |error|alert"
                            println("================================")
                        }else if(strReplyCode == "99" || strReplyCode.equalsIgnoreCase("99")){
                            println("================================")
                            println("Internal Service Error")
                            replyMesg = "Internal Service Error! |error|alert"
                            println("================================")
                        }else{
                            //============================
                            // E-PRN payment notification successful
                            println("===   *****  E-PRN payment notification successful ******* =======")
                            
                            println("SSS strReplyCode: "+strReplyCode)
                            replyMesg = "E-PRN payment notification successful |success|alert"
                            println("==================================================")
                            //===========================================
                            sssXMLReturnvalue =""            
                            sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#'  
                           
                        }
                       println("soapResponse: "+soapResponse.getSOAPBody())
                       soapResponse.writeTo(System.out);
                       System.out.println();
            }
            if(sssMethods == "loadEmployerStatus"){
                        
                        // find your node based on tag name
                        NodeList amount = soapBody.getElementsByTagName("amount");
                        NodeList replyDate = soapBody.getElementsByTagName("replyDate");
                        NodeList appmo = soapBody.getElementsByTagName("appmo");
                        NodeList brnum = soapBody.getElementsByTagName("brnum");
                        NodeList erbrn = soapBody.getElementsByTagName("erbrn");
                        NodeList ernum = soapBody.getElementsByTagName("ernum");
                       
                        NodeList ername = soapBody.getElementsByTagName("ername");
                        NodeList replyCode = soapBody.getElementsByTagName("replyCode");


                       // declaration of string container of each nodes
                            String strBrrnumber = null;
                            String strAmount = null;
                            String strReplyDate = null;
                            String strAppmo = null;
                            String strErbrn = null;
                            String strErname = null;
                            String strReplyCode = null;
                            String strErnum = null;
                        //==============================================

                                    // set values to get the name inside the xml data code
                        // By CRD TEAM Batch TEAM POGI
                            Node nodeAmount = amount.item(0);
                            Node nodeReplyDate = replyDate.item(0);
                            Node nodeAppmo = appmo.item(0);
                            Node nodeBrnum = brnum.item(0);
                            Node nodeErbrn = erbrn.item(0);
                            Node nodeErnum = ernum.item(0);
                            Node nodeErname = ername.item(0);
                            Node nodeReplyCode = replyCode.item(0);

                        //======================================================
                        strAmount = nodeAmount != null ? nodeAmount.getTextContent() : "";
                        strReplyDate = nodeReplyDate != null ? nodeReplyDate.getTextContent() : "";
                        strAppmo = nodeAppmo != null ? nodeAppmo.getTextContent() : "";
                        strBrrnumber = nodeBrnum != null ? nodeBrnum.getTextContent() : "";
                        strErbrn = nodeErbrn != null ? nodeErbrn.getTextContent() : "";
                        strErname = nodeErname != null ? nodeErname.getTextContent() : "";
                        strReplyCode = nodeReplyCode != null ? nodeReplyCode.getTextContent() : "";
                        strErnum = nodeErnum != null ? nodeErnum.getTextContent() : "";
                        if(strReplyCode == "1" || strReplyCode.equalsIgnoreCase("1")){
                            println("================================")
                            println("Not Found in Master File")
                            replyMesg = "Not Found in Master File !"; 
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strReplyCode == "2" || strReplyCode.equalsIgnoreCase("2")){
                            println("================================")
                            println("Already Paid")   
                            replyMesg = "Already Paid !"
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strReplyCode == "98" || strReplyCode.equalsIgnoreCase("98")){
                            println("================================")
                            println("Authentication Error") 
                             replyMesg = "Authentication Error!"
                             sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else if(strReplyCode == "99" || strReplyCode.equalsIgnoreCase("99")){
                            println("================================")
                            println("Internal Service Error")
                            replyMesg = "Internal Service Error!"
                            sssXMLReturnvalue = replyMesg + '@@#'
                            println("================================")
                        }else{
                            //============================
                            // FOUND IN MASTER FILE
                            println("===   *****  FOUND IN MASTER FILE ******* =======")
                            println("SSS Amount: "+strAmount)   
                            println("SSS Reply Date: "+strReplyDate)   
                            println("SSS App No: "+strAppmo) 
                            println("SSS BRR Number: "+strBrrnumber) 
                            println("SSS ER BRN: "+strErbrn)
                            println("SSS ER NAME: "+strErname)
                            println("SSS strReplyCode: "+strReplyCode)
                            replyMesg = "Successfully found in the Master File |success|alert"
                            println("==================================================")
                                        //===========================================
                            sssXMLReturnvalue =""            
                            sssXMLReturnvalue = strErnum + '@@#' +strAmount + '@@#' + strReplyDate + '@@#' + strAppmo+ '@@#' + strBrrnumber + '@@#' + strErbrn  + '@@#' + strErname + '@@#' + strReplyCode+ '@@#' + replyMesg+ '@@#'  
                           
                        }
                       System.out.println("loadEmployerStatus: Response SOAP Message:");
                       println("soapResponse: "+soapResponse.getSOAPBody())
                       soapResponse.writeTo(System.out);
                       System.out.println();
                       
            }
            if(sssMethods == "submitPaidIPRNum"){
                System.out.println("submitPaidIPRNum: Response SOAP Message:");
                NodeList replyCode = soapBody.getElementsByTagName("return");
                Node nodeReplyCode = replyCode.item(0);
                String strReplyCode = null;
                strReplyCode = nodeReplyCode != null ? nodeReplyCode.getTextContent() : "";
                if(strReplyCode == "2" || strReplyCode.equalsIgnoreCase("2")){
                    println("================================")
                    println("I-PRN is already paid !")   
                    replyMesg = "I-PRN is already paid! |info|alert"
                    sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#' 
                    println("================================")
                }else if(strReplyCode == "98" || strReplyCode.equalsIgnoreCase("98")){
                    println("================================")
                    println("Authentication Error") 
                     replyMesg = "Authentication Error! |error|alert"
                     sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#' 
                    println("================================")
                }else if(strReplyCode == "99" || strReplyCode.equalsIgnoreCase("99")){
                    println("================================")
                    println("Internal Service Error")
                    replyMesg = "Internal Service Error! |error|alert"
                    println("================================")
                    sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#' 
                }else{
                    //============================
                    // E-PRN payment notification successful
                    println("===   *****  E-PRN payment notification successful ******* =======")

                    println("SSS strReplyCode: "+strReplyCode)
                    replyMesg = "E--PRN saved/tagged as paid (Success) !|success|alert"
                    println("==================================================")
                    //===========================================
                    sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#'  

                }

                System.out.println("loadEmployerStatus: Response SOAP Message:");
                       println("soapResponse: "+soapResponse.getSOAPBody())
                       soapResponse.writeTo(System.out);
                       System.out.println();
                
            }
            if(sssMethods == "loadIndividualPRNChange"){
                NodeList membername = soapBody.getElementsByTagName("eename");
                NodeList membernum = soapBody.getElementsByTagName("eenum");
                NodeList fapid = soapBody.getElementsByTagName("fapld");
                NodeList prnnumber = soapBody.getElementsByTagName("iprnum");
                NodeList replyCode = soapBody.getElementsByTagName("repcd");
                NodeList replyDate = soapBody.getElementsByTagName("repdt");

                NodeList tapid = soapBody.getElementsByTagName("tapld");
                NodeList amount = soapBody.getElementsByTagName("tsamt");

                
                // declaration of string container of each nodes
                     String strErnum = null;
                     String strAmount = null;
                     String strReplyDate = null;
                     String strFapid = null;
                     String strTapid = null;
                     String strErname = null;
                     String strReplyCode = null;
                     String strPrn = null;
                 //==============================================
                   
                             // set values to get the name inside the xml data code
                 // By CRD TEAM Batch TEAM POGI
                     Node nodeErname = membername.item(0);
                     Node nodeMemberNumber = membernum.item(0);
                     Node nodeFapid = fapid.item(0);
                     Node nodePrn = prnnumber.item(0);
                     Node nodeReplyCode = replyCode.item(0);
                     Node nodeReplyDate = replyDate.item(0);
                     Node nodeTapid = tapid.item(0);
                     Node nodeAmount = amount.item(0);
                 
                 //======================================================
                 
                 strErnum = nodeMemberNumber != null ? nodeMemberNumber.getTextContent() : "";
                 strAmount = nodeAmount != null ? nodeAmount.getTextContent() : "";
                 strReplyDate = nodeReplyDate != null ? nodeReplyDate.getTextContent() : "";
                 strFapid = nodeFapid != null ? nodeFapid.getTextContent() : "";
                 strTapid = nodeTapid != null ? nodeTapid.getTextContent() : "";
                 strErname = nodeErname != null ? nodeErname.getTextContent() : "";
                 strReplyCode = nodeReplyCode != null ? nodeReplyCode.getTextContent() : "";
                 strPrn = nodePrn != null ? nodePrn.getTextContent() : "";
                 
                if(strReplyCode == "1" || strReplyCode.equalsIgnoreCase("1")){
                    println("================================")
                    println("I-PRN is not generated!")   
                    replyMesg = "I-PRN is not generated!"
                    sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#' 
                    println("================================")
                }else if(strReplyCode == "98" || strReplyCode.equalsIgnoreCase("98")){
                    println("================================")
                    println("Authentication Error") 
                     replyMesg = "Authentication Error!"
                     sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#' 
                    println("================================")
                }else if(strReplyCode == "99" || strReplyCode.equalsIgnoreCase("99")){
                    println("================================")
                    println("Internal Service Error")
                    replyMesg = "Internal Service Error!"
                    println("================================")
                    sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strReplyCode+ '@@#' + replyMesg+ '@@#' 
                }else{
                    //============================
                    // E-PRN payment notification successful
                    println("===   *****  New I-PRN is generated notification successful ******* =======")

                    println("SSS strReplyCode: "+strReplyCode)
                    replyMesg = "New I-PRN is generated (Success) !|success|alert"
                    println("==================================================")
                    //===========================================
                    //strErnum/strAmount/strReplyDate/strFapid/strTapid/strErname/strReplyCode/strPrn
                    println("===   *****  FOUND IN MASTER FILE ******* =======")
                    println("SSS NUMBER: "+strErnum)   
                    println("SSS Amount: "+strAmount)   
                    println("SSS Reply Date: "+strReplyDate) 
                    println("SSS Applicable Month Start: "+strFapid) 
                    println("SSS Applicable Month End: "+strTapid)
                    println("SSS ER NAME: "+strErname)
                    println("SSS strReplyCode: "+strReplyCode)
                    println("SSS New Generated Prn: "+strPrn)
                    replyMesg = "New I-PRN is generated (Success) !|success|alert"
                    println("==================================================")
                                //===========================================
                    sssXMLReturnvalue =""            
                    sssXMLReturnvalue = strErnum + '@@#' +strAmount + '@@#' + strReplyDate + '@@#' + strTapid+ '@@#'+ strFapid+ '@@#' + strPrn + '@@#' + strErnum  + '@@#' + strErname + '@@#' + strReplyCode+ '@@#' + replyMesg+ '@@#'    

                }
                System.out.println("loadIndividualPRNChange: Response SOAP Message:");
                println("soapResponse: "+soapResponse.getSOAPBody())
                soapResponse.writeTo(System.out);
                System.out.println();
                    
            }
            

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

    public static SOAPMessage createSOAPRequest(String soapAction, String soapMethod) throws Exception {
        
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        println "4th : " + soapMethod 
        createSoapEnvelope(soapMessage, soapMethod );

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }
    
}
