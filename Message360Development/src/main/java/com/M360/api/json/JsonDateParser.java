package com.M360.api.json;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.M360.api.configuration.M360Constants;

public class JsonDateParser extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException,
			JsonProcessingException {
		String date = jsonparser.getText();
		//System.out.println("20 date:"+date);
		if (date == null)
			return null;
		try {
			return M360Constants.jsonDateFormat.parse(date);
		} catch (ParseException e) {
			//System.out.println("Exception in Parsing "+e);;
			return null;
		}

	}
}
