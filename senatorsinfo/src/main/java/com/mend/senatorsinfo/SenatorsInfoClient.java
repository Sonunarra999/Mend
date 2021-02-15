package com.mend.senatorsinfo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mend.senatorsinfo.model.Address;
import com.mend.senatorsinfo.model.ContactInformation;
import com.mend.senatorsinfo.model.Member;

public class SenatorsInfoClient 
{
    public static void main( String[] args ) throws Exception
    {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	factory.setNamespaceAware(true);
    	Document document = factory.newDocumentBuilder().parse(new URL("https://www.senate.gov/general/contact_information/senators_cfm.xml").openStream());
    	NodeList nodeList = document.getElementsByTagName("member");
    	ContactInformation contactInformation = new ContactInformation();
    	List<Member> members = new ArrayList<Member>();
    	
    	for (int i =0; i < nodeList.getLength(); i++) {
    		Member member = new Member();
    		Node node = nodeList.item(i);
    		if(node.getNodeType() == Node.ELEMENT_NODE) {
    			Element element = (Element) node; 
    			member.setFullName(element.getElementsByTagName("member_full").item(0).getTextContent());
    			member.setFirstName(element.getElementsByTagName("first_name").item(0).getTextContent());
    			member.setLastName(element.getElementsByTagName("last_name").item(0).getTextContent());
    			member.setMobile(element.getElementsByTagName("phone").item(0).getTextContent());
    			member.setChartId(element.getElementsByTagName("bioguide_id").item(0).getTextContent());
    			String addressElement = element.getElementsByTagName("address").item(0).getTextContent();
    			String[] addressSplit = addressElement.split(" ");
    			List<Address> addresses = new ArrayList<Address>();
    			Address address = new Address();
    			if (addressSplit.length == 8) {
    				address.setStreet(addressSplit[0] + " " + addressSplit[1] + " " + addressSplit[2] + " " + addressSplit[3] + " " + addressSplit[4]);
    				address.setCity(addressSplit[5]);
    				address.setState(addressSplit[6]);
    				address.setPostal(addressSplit[7]);
    				addresses.add(address);
    				member.setAddress(addresses);
    			}
    			members.add(member);
    		}
    	}
    	contactInformation.setMembers(members);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	System.out.println("************Json Object using ObjectMapper*******\n");
    	System.out.println(mapper.writeValueAsString(contactInformation));
    	System.out.println("\n************Json Object using toString()*******\n");
    	System.out.println(contactInformation.toString());
    }
}
