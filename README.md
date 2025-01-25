Weather Web App 🌤️

![Image](https://github.com/user-attachments/assets/c1381c61-a2c0-4ca9-bd53-3fbc924ed2c1)






This is a dynamic web application that fetches and displays real-time weather information for any city using the OpenWeather API. 
The app is built with Java Servlets, JSP, and a responsive front-end using HTML, CSS, and JavaScript.

Features
1.Search Weather by City: Enter the name of any city to get the latest weather details.

2.Real-Time Data: Fetches live weather data including temperature, humidity, wind speed, and overall conditions.

3.Dynamic Icons: Displays weather-specific icons (e.g., sunny, cloudy, rainy) based on the current weather condition.

4.Responsive UI: Styled with modern CSS to work seamlessly across devices.

Technologies Used
1.Frontend: HTML, CSS, JavaScript

2.Backend: Java Servlets, JSP

3.API: OpenWeather API

4.Libraries: Google Gson for JSON parsing

5.Tools: Apache Tomcat for deployment

Project Structure
1.Servlet (Myservlet.java): Handles HTTP requests, fetches data from the OpenWeather API, and forwards it to the JSP.

2.JSP (index.jsp): Displays the weather information dynamically using data provided by the servlet.

Static Files:
1.style.css: Styles for the UI.

2.myscript.js: Client-side logic for dynamic updates like weather icons.

How It Works
1.The user enters a city name in the search bar.

2.The app sends the city name to the backend servlet via an HTTP POST request.

3.The servlet fetches weather data from the OpenWeather API, processes the response, and forwards it to the JSP.

4.The JSP renders the weather data dynamically on the page, including date, temperature, humidity, wind speed, and weather condition.
