package MyPakage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	
       
    
    public Myservlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String city = request.getParameter("city");
	    String apiKey = "1e0fcf3349669e40bec0a22dde4b9b77";
	    String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

	    try {
	        URL url = new URL(apiUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");

	        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            response.getWriter().write("Error: Unable to fetch weather data. Response code: " + connection.getResponseCode());
	            return;
	        }

	        InputStream inputStream = connection.getInputStream();
	        Scanner scanner = new Scanner(new InputStreamReader(inputStream));
	        StringBuilder responseContent = new StringBuilder();
	        while (scanner.hasNext()) {
	            responseContent.append(scanner.nextLine());
	        }
	        scanner.close();

	        Gson gson = new Gson();
	        JsonObject jsonObject = gson.fromJson(responseContent.toString(), JsonObject.class);

	        long dateTimestamp = jsonObject.get("dt").getAsLong() * 1000;
	        String date = new Date(dateTimestamp).toString();

	        double temperatureKelvin = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
	        int temperatureCelsius = (int) (temperatureKelvin - 273.15);

	        int humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsInt();
	        double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();
	        String weatherCondition = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();

	        request.setAttribute("date", date);
	        request.setAttribute("city", city);
	        request.setAttribute("temperature", temperatureCelsius);
	        request.setAttribute("weatherCondition", weatherCondition);
	        request.setAttribute("humidity", humidity);
	        request.setAttribute("windSpeed", windSpeed);

	        connection.disconnect();
	        request.getRequestDispatcher("index.jsp").forward(request, response);

	    } catch (IOException e) {
	        e.printStackTrace();
	        response.getWriter().write("Error occurred: " + e.getMessage());
	    }
	}
}
