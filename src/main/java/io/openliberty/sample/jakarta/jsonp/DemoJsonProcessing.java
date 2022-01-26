package io.openliberty.sample.jakarta.jsonp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.*;
import javax.json.stream.JsonParserFactory;


public class DemoJsonProcessing {
	
	public static void main(String[] args) {
		writeJson(readJson("src/main/java/io/openliberty/sample/jakarta/jsonp/data.json"));
		writeJson(buildJson());
	}
	
	public static JsonObject readJson(String filepath) {
		try {
			InputStream is = new FileInputStream(filepath);
			JsonReaderFactory factory = Json.createReaderFactory(null);;
			JsonReader jsonReader = factory.createReader(is);
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();
	        is.close();
			return jsonObject;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeJson(JsonObject jsonObject) {
		Map<String, Boolean> config = new HashMap<String, Boolean>();
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		JsonWriterFactory factory = Json.createWriterFactory(config);
		StringWriter sw = new StringWriter();
		
		try (JsonWriter jsonWriter = factory.createWriter(sw)) {
			jsonWriter.writeObject(jsonObject);
			System.out.println(sw);
		}
	}
	
	public static JsonObject buildJson() {
		Map<String, Boolean> config = new HashMap<String, Boolean>();
		
		JsonBuilderFactory factory = Json.createBuilderFactory(config);
		JsonObject jsonObject = factory.createObjectBuilder()
				.add("name", "Jane Doe")
				.add("birthday", LocalDate.of(1995, 6, 12).toString())
				.add("languages", factory.createArrayBuilder()
						.add("Java")
						.add("Python"))
				.build();
		return jsonObject;
	}
}
