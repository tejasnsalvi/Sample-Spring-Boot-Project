package com.demigod.tutorial.utils;

import com.demigod.tutorial.exception.MyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.StandardLevel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class MyUtil {

    @Resource(name = "filePath")
    private String filePath;

    private static final Logger logger = LogManager.getLogger();

    /**
     * This will help you write data into a file just replace .csv to .txt or any other format
     * @param data
     * @param isAppend
     * @param filePath
     */
    public void writeToCsv(StringBuilder data, Boolean isAppend, String filePath) {
        FileWriter fileWriter = null;
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (data != null) {
            try {
                fileWriter = new FileWriter(filePath + ".csv", isAppend);
                fileWriter.append(data);
            } catch (IOException e) {
                throw (new MyException("MyUtil.writeToCsv.IOException", e, StandardLevel.ERROR));
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    throw (new MyException("MyUtil.writeToCsv.IOException", e, StandardLevel.ERROR));
                }
            }
        }
    }

    /*Check wether a string is null or empty
    This method is reqd since doing null check with OR operator is cubersome.
    */
    public boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
