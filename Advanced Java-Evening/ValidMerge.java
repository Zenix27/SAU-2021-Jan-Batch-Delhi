import java.util.* ;
import java.io.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.text.SimpleDateFormat;
import org.w3c.dom.Element;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;

public class ValidMerge
{
	public static void main(String[] args)
	{
		try 
		{
		File fil1 = new File("/Users/Zenix/Desktop/AU Spring 2021/SAU-2021-Jan-Batch-Delhi/Advanced Java-Evening/xmlFile1.xml");
	        File fil2 = new File("/Users/Zenix/Desktop/AU Spring 2021/SAU-2021-Jan-Batch-Delhi/Advanced Java-Evening/xmlFile2.xml");
	        
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        
	        Document D1 = dBuilder.parse(fil1);
	        Document D2 = dBuilder.parse(fil2);
	     
	        Document vFile = dBuilder.newDocument();
	        Document invFile = dBuilder.newDocument();
	        Document mFile = dBuilder.newDocument() ;

	        D1.getDocumentElement().normalize();
	        D2.getDocumentElement().normalize();

	        NodeList doc_1 = D1.getElementsByTagName("CSR_Producer");
	        NodeList doc_2 = D2.getElementsByTagName("CSR_Producer");

	        Element vRoot = vFile.createElement("CSR_Producer");
	        vFile.appendChild(vRoot);

	        Element invRoot = invFile.createElement("CSR_Producer");
	        invFile.appendChild(invRoot);
	        
	        Element root = mFile.createElement("CSR_Producer");
	        mFile.appendChild(root);

	        for (int i=0;i<doc_1.getLength();i++)
	        {
	        	Element currElement = (Element) doc_1.item(i);
	            NodeList liclist = currElement.getElementsByTagName("License");
	            
	            for (int j=0;j<liclist.getLength();j++)
	            {
	            	Element current_license = (Element) liclist.item(j);
	                String date = current_license.getAttribute("License_Expiration_Date");
	                
	                Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
	                Date now = new Date();
	                
	                if (expiry.compareTo(now) > 0)
	                {
	                	Node newElement = vFile.importNode(current_license, true);
	                    vRoot.appendChild(newElement);
	                    print(vFile, "/Users/Zenix/Desktop/AU Spring 2021/SAU-2021-Jan-Batch-Delhi/Advanced Java-Evening/xmlValid.xml");
	                    } 
	                
	                else
	                {
	                	Node newElement = invFile.importNode(current_license, true);
	                    invRoot.appendChild(newElement);
	                    print(invFile, "/Users/Zenix/Desktop/AU Spring 2021/SAU-2021-Jan-Batch-Delhi/Advanced Java-Evening/xmlInvalid.xml");
	                    }
	                }
	            }
	        for (int i=0;i<doc_2.getLength();i++)
	        {
	        	Element currElement = (Element) doc_2.item(i);
	            NodeList liclist = currElement.getElementsByTagName("License");

	            for (int j=0;j<liclist.getLength();j++)
	            {
	            	Element currentLicense = (Element) liclist.item(j);
	                String date = currentLicense.getAttribute("License_Expiration_Date");
	                
	                Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
	                Date now = new Date();
	                if (expiry.compareTo(now) > 0)
	                {
	                	Node newElement = vFile.importNode(currentLicense, true);
	                    vRoot.appendChild(newElement);
	                    print(vFile, "/Users/Zenix/Desktop/AU Spring 2021/SAU-2021-Jan-Batch-Delhi/Advanced Java-Evening/xmlValid.xml");
	                    } 
	                else 
	                {
	                	Node newElement = invFile.importNode(currentLicense, true);
	                    invRoot.appendChild(newElement);
	                    print(invFile, "/Users/Zenix/Desktop/AU Spring 2021/SAU-2021-Jan-Batch-Delhi/Advanced Java-Evening/xmlInvalid.xml");
	                    }
	                }
	            }
	        for(int z=0;z<doc_1.getLength();z++) 
	        {
	        	Node element1 = doc_1.item(z);
	        	
	        	for(int i=0;i<doc_2.getLength();i++)
	        	{
	        		Node element2 = doc_2.item(i) ;
	                Element currElement1 = (Element) element1 ;
	                Element currElement2 = (Element) element2 ;
	                
	                if( currElement1.getAttribute("NIPR_Number").equals(currElement2.getAttribute("NIPR_Number")) )
	                {
	                	NodeList list1 = currElement1.getElementsByTagName("License");
	                	for(int j = 0 ; j < list1.getLength() ; j++)
	                	{
	                		Element licenseElement1 = (Element)list1.item(j);
	                        NodeList list2 = currElement2.getElementsByTagName("License");
	                        
	                        for(int k = 0 ; k < list2.getLength() ; k++)
	                        {
	                        	Element licenseElement2 = (Element)list2.item(k) ;
	                        	
	                        	if(licenseElement1.getAttribute("State_Code").equals(licenseElement2.getAttribute("State_Code"))
	                                && licenseElement1.getAttribute("License_Number").equals(licenseElement2.getAttribute("License_Number"))
	                                && licenseElement1.getAttribute("License_Expiration_Date").equals(licenseElement2.getAttribute("License_Expiration_Date")))
	                        	{
	                        		Node newElement = mFile.importNode(licenseElement2, true) ;
	                                root.appendChild(newElement) ;
	                                
	                                print(mFile,"/Users/Zenix/Desktop/AU Spring 2021/SAU-2021-Jan-Batch-Delhi/Advanced Java-Evening/xmlMerge.xml");
	                              }
	                        	}
	                      }
	                   }
	               }
	           }
	        } 
		catch (Exception e)
		{
			e.printStackTrace();
	        System.out.println();
	        }
		}
	
	public static final void print(Document xml, String filename) throws Exception
	{
		Transformer tf = TransformerFactory.newInstance().newTransformer();
	    tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
	    }
	}
