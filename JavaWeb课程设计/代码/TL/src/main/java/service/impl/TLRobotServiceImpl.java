package service.impl;

import org.springframework.stereotype.Service;
import service.ITLRobotService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class TLRobotServiceImpl implements ITLRobotService {


    private static String USERID = "684882";
    private static String APIKEY = "b4c43a4cb0164fdfa8604a0f325f7269";

    public String askQuestion(String question) throws IOException{
        String info = URLEncoder.encode(question,"utf-8");
        String url = "http://www.tuling123.com/openapi/api?key="+APIKEY
                +"&info="+info+"&userid="+USERID;
        String ask = "";

        System.out.println(url);
            URL getUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.connect();

            //缓冲流读取
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(),"utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine())!=null){
                stringBuffer.append(line);
            }

            reader.close();
            connection.disconnect();

            ask = stringBuffer.toString();


        return ask;
    }
}
