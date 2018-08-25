package com.find.job.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static String bean2Json(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
        mapper.writeValue(gen, obj);
        gen.close();
        return sw.toString();
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, objClass);
    }

    public static <T> List<T> json2List(String jsonStr, Class<T> objClass)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        JavaType type = getCollectionType(ArrayList.class, objClass);
        return mapper.readValue(jsonStr, type);
    }


    public static JavaType getCollectionType(Class<?> collectionClass, Class<?> elementClasses) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.getTypeFactory().constructParametrizedType(collectionClass, collectionClass, elementClasses);
    }

}
