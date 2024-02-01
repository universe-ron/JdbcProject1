package welcome.welcome;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class welcome {
    public static void main(String[] args) {
        try {
            // 获取URL中的数据
            String jsonData = fetchData("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvOutdoorEdu.aspx?IsTransData=1&UnitId=242");

            // 将JSON数据转换为Java对象
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            // 连接到数据库
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldemo", "root", "springboot");

            // 将数据插入数据库表
            insertDataIntoTable(connection, jsonNode);

            // 关闭数据库连接
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String fetchData(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        reader.close();
        connection.disconnect();

        return result.toString();
    }

    private static void insertDataIntoTable(Connection connection, JsonNode jsonNode) throws SQLException {
        // 编写逻辑将从URL获取的数据插入数据库表
        // 使用PreparedStatement等方式执行SQL语句
        // 例如：PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO your_table_name (column1, column2, ...) VALUES (?, ?, ...)");

        // 迭代JSON数组
        for (JsonNode record : jsonNode) {
            // 创建PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO data (FarmNm_CH, TEL, FAX, PCODE, County, Township, Address_CH, Address_EN, WebURL, Longitude, Latitude, ServeItem, Facebook) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // 设置参数并执行插入操作
            preparedStatement.setString(1, record.path("FarmNm_CH").asText().toLowerCase());
            preparedStatement.setString(2, record.path("TEL").asText().toLowerCase());
            preparedStatement.setString(3, record.path("FAX").asText().toLowerCase());
            preparedStatement.setString(4, record.path("PCODE").asText().toLowerCase());
            preparedStatement.setString(5, record.path("County").asText().toLowerCase());
            preparedStatement.setString(6, record.path("Township").asText().toLowerCase());
            preparedStatement.setString(7, record.path("Address_CH").asText().toLowerCase());
            preparedStatement.setString(8, record.path("Address_EN").asText().toLowerCase());
            preparedStatement.setString(9, record.path("WebURL").asText().toLowerCase());
            preparedStatement.setString(10, record.path("Longitude").asText().toLowerCase());
            preparedStatement.setString(11, record.path("Latitude").asText().toLowerCase());
            preparedStatement.setString(12, record.path("ServeItem").asText().toLowerCase());
            preparedStatement.setString(13, record.path("Facebook").asText().toLowerCase());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
    }
}
