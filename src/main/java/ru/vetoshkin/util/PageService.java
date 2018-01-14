package ru.vetoshkin.util;
import java.util.HashMap;
import java.util.Map;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class PageService {

    private static final Map<String, String> pages = new HashMap<>();

    public static void init() {
        pages.put("trainer-list",   "/pages/trainer/list.jsp");
        pages.put("trainer-add",    "/pages/trainer/add.jsp");
        pages.put("sportsman-list", "/pages/sportsman/list.jsp");
        pages.put("sportsman-add",  "/pages/sportsman/add.jsp");
    }


    public static String getPage(String action) {
        return pages.get(action);
    }

}
