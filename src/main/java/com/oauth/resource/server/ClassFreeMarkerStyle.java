package com.oauth.resource.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class ClassFreeMarkerStyle {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		try {
			Object[] fileStr = readFromFile().toArray();
			for (int i = 0; i < readFromFile().size() - 1; i = i + 2) {

				String objName = fileStr[i].toString();
				String fields = fileStr[i + 1].toString();

				createController(objName, "Controller",	"src/main/java/com/oauth/resource/controller/", outList(fields));
				createController(objName, "Dao", "src/main/java/com/oauth/resource/dao/api/", outList(fields));
				createController(objName, "DaoImpl", "src/main/java/com/oauth/resource/dao/impl/", outList(fields));
				createController(objName, "Model", "src/main/java/com/oauth/resource/domain/", outList(fields));
				createController(objName, "Service", "src/main/java/com/oauth/resource/service/api/", outList(fields));
				createController(objName, "ServiceImpl", "src/main/java/com/oauth/resource/service/impl/", outList(fields));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createController(String objName, String objType, String path, Map<String, String> inList) {
		@SuppressWarnings("deprecation")
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(ClassFreeMarkerStyle.class, "/");
		try {

			Template simpleTemplate = configuration.getTemplate(objType + ".ftl");

			Map<String, Object> myMap = new HashMap<String, Object>();
			myMap.put("object", objName);
			myMap.put("fields", inList);

			// File output
			Writer file = new FileWriter(new File(path + objName + objType + ".java"));
			simpleTemplate.process(myMap, file);
			file.flush();
			file.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Map<String, String> outList(String fields) throws JsonParseException, JsonMappingException, IOException {

		String message = fields;

		message = message.replace("{", "{\"");
		message = message.replace(":", "\":\"");
		message = message.replace(",", "\",\"");
		message = message.replace("}", "\"}");
		System.out.println("**************************************************************");
		System.out.println(message);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<LinkedHashMap<String, String>> typeRef = new TypeReference<LinkedHashMap<String, String>>() {
		};
		return mapper.readValue(message, typeRef);
	}

	@SuppressWarnings("resource")
	public static List<String> readFromFile() {

		List<String> list = new ArrayList<String>();
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File file = new File(classLoader.getResource("columns.txt").getFile());
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str;
			while ((str = in.readLine()) != null) {
				list.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return list;
	}
}
