package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import entity.Student;

import java.util.List;

public class ToJson {

    public static String listToJasonString(List<Student> ls){
        return JSON.toJSONString(ls, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
    }
}
