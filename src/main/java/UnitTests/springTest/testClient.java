package UnitTests.springTest;

import Application.model.CategoryFactory;
import Application.model.Graduate;
import Application.model.ListenerProfessionalDataSet;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Calendar;

/**
 * Created by Rushan on 24.02.2016.
 */
public class testClient {
    public static void main(String[] args) throws Exception{
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = new java.sql.Date(calendar.getTimeInMillis());
        int contractID = 3;
        CategoryFactory factory = new CategoryFactory();
        CategoryFactory.AcademicRank academicRank = factory.academicRankCreate();
        CategoryFactory.AcademicDegree academicDegree = factory.academicDegreeCreate();
        CategoryFactory.Position position = factory.positionCreate();
        CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();
        academicDegree.setID(1);
        academicDegree.setName("name1");
        academicRank.setID(1);
        academicRank.setName("name1");
        position.setID(1);
        position.setName("name1");
        subdivision.setID(1);
        subdivision.setName("name1");
        ListenerProfessionalDataSet dataSet = new ListenerProfessionalDataSet(subdivision, position, academicDegree, academicRank);
        Graduate graduate1 = new Graduate(contractID, dataSet, date);
        graduate1.setID(1);


        String url = "http://localhost:8080/logs";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity postingString = new StringEntity(graduate1.toJSON().toString());//gson.tojson() converts your pojo to json
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        post.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(post);

    }
}
