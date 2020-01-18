package com.consistent.main;

import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.consistent.main.mapping.Mapping;
import com.consistent.main.mapping.MarcaMapping;
import com.consistent.main.mapping.RateMapping;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Main {

	public static void main(String[] args) throws XMLStreamException, IOException, SAXException, ParserConfigurationException {
		HashSet<RateMapping> mRate = new HashSet<RateMapping>();
		mRate.add(new RateMapping("", "", "", "", "", "", "", "", "", "", "", "", "", ""));
		mRate.add(new RateMapping("", "", "", "", "", "", "", "", "", "", "", "", "", ""));
		mRate.add(new RateMapping("", "", "", "", "", "", "", "", "", "", "", "", "", ""));
		for (RateMapping rateMapping : mRate) {
			System.out.println(rateMapping.getMapping());
		}
		Mapping mapping = new MarcaMapping("", "", "", "", "", mRate);
		mapping.getMapping();
	}
	
	 private static String convertDocumentToString(Document doc) {
	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer transformer;
	        try {
	            transformer = tf.newTransformer();
	            // below code to remove XML declaration
	            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	            StringWriter writer = new StringWriter();
	            transformer.transform(new DOMSource(doc), new StreamResult(writer));
	            String output = writer.getBuffer().toString();
	            return output;
	        } catch (TransformerException e) {
	            e.printStackTrace();
	        }
	        
	        return null;
	    }
	
	private static Document convertStringToDocument(String xmlStr) {
		
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
	
	private static boolean getIntervals(String i, String f, String date){
		
		boolean estado = false;
		try {
			String d = date.replace('/','-');
			String init = i.replace('/','-');
			String end = f.replace('/','-');
			String fi = (end.equals(""))? DateTime.now().toString():end;
			DateTime inicio = new DateTime(init);
			DateTime fin = new DateTime(fi);
			Interval interval = new Interval(inicio, fin);
			estado = interval.contains(new DateTime(d));
			System.out.println(estado);
			} catch (IllegalArgumentException e) {
			// TODO: handle exception
				e.getStackTrace();
			}
		return estado;
	}
	
	

}
