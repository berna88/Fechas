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
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class Main {

	public static void main(String[] args) throws XMLStreamException, IOException, SAXException, ParserConfigurationException {
		Mapping mRate = new RateMapping();
		//System.out.println(mRate.getMapping());
		Mapping mMarca = new MarcaMapping("2453890", "", "", "AQUA", "español", (RateMapping) mRate);
		mMarca.getMapping();
		
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
