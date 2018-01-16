package ru.vetoshkin.service;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.vetoshkin.bean.Standard;
import ru.vetoshkin.core.HikariPool;
import ru.vetoshkin.core.SystemException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;





/**
 * Ветошкин А.В. РИС-16бзу
 * */
public class StandardService {

    private static final Logger logger = LogManager.getLogger(StandardService.class);


    public static List<Standard> getAll(boolean sex, int age) throws SystemException {
        try (Connection connection = HikariPool.getSource().getConnection()) {

            String method = "{? = call get_standard(?, ?)}";
            List<Standard> result = new ArrayList<>();

            connection.setAutoCommit(false);
            CallableStatement statement = connection.prepareCall(method);
            statement.registerOutParameter(1, Types.OTHER);

            statement.setBoolean(2, sex);
            statement.setInt(3, age);

            logger.info(method);
            statement.execute();

            ResultSet set = (ResultSet) statement.getObject(1);
            while (set.next()) {
                result.add(createStandard(set));
            }

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    private static Standard createStandard(ResultSet set) throws SystemException {
        try {
            Standard result = new Standard();

            result.setId(set.getInt(1));
            result.setName(set.getString(2));
            result.setRequier(set.getDouble(3));
            result.setType(set.getString(4));
            result.setDesc(set.getString(5));

            return result;
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }


    public static void removeStandard(int id) throws SystemException {
        throw new UnsupportedOperationException("");
    }
}
