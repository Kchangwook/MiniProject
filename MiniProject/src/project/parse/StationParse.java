package project.parse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import project.util.ConnectURL;

public class StationParse {

		
	   public static void main(String args[]) throws Exception{
		   StationParse i = new StationParse();
		   System.out.println(i.parse());
	   }

	   public List<Map<String,String>> parse() throws Exception{
	      StringBuilder urlBuilder = new StringBuilder();
	      Document document = null;
	      List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	      
	      try {
	         urlBuilder.append("http://openapi.kepco.co.kr/service/evInfoService/getEvSearchList");
	         urlBuilder.append("?"+URLEncoder.encode("numOfRows","UTF-8")+"="+URLEncoder.encode("700","UTF-8"));
	         urlBuilder.append("&"+URLEncoder.encode("ServiceKey","UTF-8")+"=W3wD1iFstFefKiNF52vHKId09mICr6NSxTblpRQmdd4%2Fd7Zm%2B4D7IG1Wlf1e8AhEJQ7gG%2Bw80ZAINtoRjIqlEw%3D%3D");
	         
	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }
	      
	      try {
	         document = new ConnectURL().run(urlBuilder.toString());
	      } catch (IOException e1) {
	         e1.printStackTrace();
	      } catch (ParserConfigurationException e1) {
	         e1.printStackTrace();
	      } catch (SAXException e1) {
	         e1.printStackTrace();
	      }
	      
	      Element root = document.getDocumentElement();
	      NodeList nodelist = root.getElementsByTagName("item");
	      Map<String,String> map =null;
	      for(int i = 0; i < nodelist.getLength(); i++) {
	         Node node = nodelist.item(i);
	         if(node.getNodeType()==Node.ELEMENT_NODE) {
	        	 map = new HashMap<>();
	            Element e = (Element) node;
	            Node temp = null;
	            String[] getTag = {"cpId","addr","csNm","cpNm","lat","longi","csId","cpTp","cpStat","statUpdateDatetime"};
	            for(int j=0;j<getTag.length;j++) {
	               if((temp = e.getElementsByTagName(getTag[j]).item(0)) != null) {
	            	  map.put(getTag[j],temp.getFirstChild().getTextContent());
	               }
	            }
	            list.add(map);
	         }
	      }
	      return list;
	   }
	}

