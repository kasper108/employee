package com.skasperiunas.employee.business.helper;

import com.skasperiunas.employee.business.repository.model.EmployeeEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String formatType = "text/csv";

    public static List<EmployeeEntity> csvToEmployeeEntity( InputStream inputStream ) throws IOException {
        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim())){

            List<EmployeeEntity> employees = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for(CSVRecord csvRecord: csvRecords){
                EmployeeEntity employee = new EmployeeEntity(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Name"),
                        csvRecord.get("Email"),
                        csvRecord.get("Phone"));
                employees.add(employee);
            }
            return employees;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse CSV file: " + e.getMessage());
        }
    }

    public static boolean hasCSVFormat( MultipartFile file ){
        if(!formatType.equals(file.getContentType())){
            return false;
        }
        return true;
    }
}
