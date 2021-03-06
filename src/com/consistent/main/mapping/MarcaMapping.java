package com.consistent.main.mapping;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class MarcaMapping implements Mapping{
	
	private String guid;
	private String code;
	private String name;
	private String title;
	private String language;
	private HashSet<RateMapping> rateMapping;
	
	public MarcaMapping(String guid, String code, String name, String title, String language, HashSet<RateMapping> rateMapping) {
		super();
		this.guid = guid;
		this.code = code;
		this.name = name;
		this.title = title;
		this.language = language;
		this.rateMapping = rateMapping;
	}
	public MarcaMapping() {
		super();
		this.guid = "";
		this.code = "";
		this.name = "";
		this.title = "";
		this.language = "";
		this.rateMapping = new HashSet<RateMapping>();
	}


	public String getGuid() {
		return guid;
	}




	public void setGuid(String guid) {
		this.guid = guid;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getLanguage() {
		return language;
	}




	public void setLanguage(String language) {
		this.language = language;
	}




	public HashSet<RateMapping> getRateMapping() {
		return rateMapping;
	}




	public void setRateMapping(HashSet<RateMapping> rateMapping) {
		this.rateMapping = rateMapping;
	}




	@Override
	public String getMapping() throws XMLStreamException, IOException {
		
		StringWriter stringWriter = new StringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xMLStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
		xMLStreamWriter.writeStartDocument();
			xMLStreamWriter.writeStartElement("contents");
				xMLStreamWriter.writeStartElement("content");
					xMLStreamWriter.writeStartElement("brand");
						xMLStreamWriter.writeStartElement("guid");
							xMLStreamWriter.writeCharacters(guid);
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("code");
							xMLStreamWriter.writeCharacters(code);
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("name");
							xMLStreamWriter.writeCharacters(name);
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("title");
							xMLStreamWriter.writeCharacters(title);
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("language");
							xMLStreamWriter.writeCharacters(language);
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("keyword");
							xMLStreamWriter.writeCharacters("");
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("order");
							xMLStreamWriter.writeCharacters(order);
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("channel");
							xMLStreamWriter.writeCharacters(channel);
						xMLStreamWriter.writeEndElement();
						xMLStreamWriter.writeStartElement("rates");
							for (RateMapping rateMappingss : rateMapping) {
								xMLStreamWriter.writeCharacters(rateMappingss.getMapping());
							}
						xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeEndElement();
				xMLStreamWriter.writeEndElement();
			xMLStreamWriter.writeEndDocument();
		xMLStreamWriter.flush();
		xMLStreamWriter.close();
		String result = stringWriter.getBuffer().toString();
		stringWriter.close(); 
		System.out.println(result);
		return result;
	}

}
