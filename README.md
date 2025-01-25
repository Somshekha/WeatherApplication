Weather Web App 🌤️
This is a dynamic web application that fetches and displays real-time weather information for any city using the OpenWeather API. The app is built with Java Servlets, JSP, and a responsive front-end using HTML, CSS, and JavaScript.

Features
Search Weather by City: Enter the name of any city to get the latest weather details.
Real-Time Data: Fetches live weather data including temperature, humidity, wind speed, and overall conditions.
Dynamic Icons: Displays weather-specific icons (e.g., sunny, cloudy, rainy) based on the current weather condition.
Responsive UI: Styled with modern CSS to work seamlessly across devices.
Technologies Used
Frontend: HTML, CSS, JavaScript
Backend: Java Servlets, JSP
API: OpenWeather API
Libraries: Google Gson for JSON parsing
Tools: Apache Tomcat for deployment
Project Structure
Servlet (Myservlet.java): Handles HTTP requests, fetches data from the OpenWeather API, and forwards it to the JSP.
JSP (index.jsp): Displays the weather information dynamically using data provided by the servlet.
Static Files:
style.css: Styles for the UI.
myscript.js: Client-side logic for dynamic updates like weather icons.
How It Works
The user enters a city name in the search bar.
The app sends the city name to the backend servlet via an HTTP POST request.
The servlet fetches weather data from the OpenWeather API, processes the response, and forwards it to the JSP.
The JSP renders the weather data dynamically on the page, including date, temperature, humidity, wind speed, and weather condition.
