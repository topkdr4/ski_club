package ru.vetoshkin;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class ScannerServlet extends CXFNonSpringJaxrsServlet {

    private static final String FILETYPE_CLASS = "class";

    @Override
    protected Map<Class<?>, Map<String, List<String>>> getServiceClasses(ServletConfig servletConfig, boolean modelAvailable, String splitChar) throws ServletException {
        Map<Class<?>, Map<String, List<String>>> result = new HashMap<>();
        try {
            Path appPath = Paths.get(getServletContext().getRealPath("/"), "WEB-INF", "classes");
            Set<Class<?>> classes = getClasses(appPath, clazz -> {
                return clazz.isAnnotationPresent(javax.ws.rs.Path.class);
            });

            for (Class<?> aClass : classes) {
                Map<String, List<String>> prop = new HashMap<>();
                result.put(aClass, prop);
            }

        } catch (IOException e) {
            throw new ServletException(e);
        }
        return result;
    }

    public static Set<Class<?>> getClasses(Path start, Predicate<Class<?>> predicate) throws IOException {
        Stream<Path> paths = Files.find(start,
                Integer.MAX_VALUE,
                (path, att) -> {
                    return path.toString().endsWith(FILETYPE_CLASS) && att.isRegularFile();
                }
        );

        final int START_PATH_STRING_LENGTH = start.toString().length();

        Set<String> res = paths.map(path -> {
            String currentPath = path.toString();
            return currentPath.substring(START_PATH_STRING_LENGTH + 1);
        }).map(ScannerServlet::className).collect(Collectors.toSet());

        return res.stream().map(name -> {
            try {
                return Class.forName(name, false, ScannerServlet.class.getClassLoader());
            } catch (ClassNotFoundException e) {
                return null;
            }
        }).filter(predicate).collect(Collectors.toSet());
    }

    private static String className(String source) {
        int length = source.length() - FILETYPE_CLASS.length() - 1;
        char[] result = new char[length];

        for (int index = 0; index < length; index++) {
            char code = source.charAt(index);

            if (code == '\\' || code == '/')
                code = '.';

            result[index] = code;
        }
        return new String(result);
    }
}
