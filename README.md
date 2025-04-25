# Survey Management Application

A simple survey management application built using Java and Dropwizard, containerized using Docker.

## 📦 Running The Application

Follow the steps below to run and test the application.

---

### 🔧 Clone and Build the Project

Make sure [Apache Maven](https://maven.apache.org/) is installed.

```bash
git clone <url>
cd survey-management-api
mvn clean install
mvn clean package
```

### 🚀 Run the Application

Run the packaged JAR file:

```bash
java -jar survey-management-api.jar
```

---

## 🐳 Running with Docker

Make sure Docker is running on your machine.

### 1. Build Docker Image

```bash
docker build -t survey-management-api .
```

### 2. Run Docker Container

```bash
docker run -v ~/.oci:/root/.oci -p 8080:8080 survey-management-api
```

---

## 📡 API Usage

### 🔄 Get Survey Data

Hit the following endpoint (refresh multiple times for testing):

```
http://localhost:8080/surveys
```

### 📤 Post Survey Data

Use the following `curl` command to send data to the application:

```bash
curl -X POST http://localhost:8080/surveys \
  -H "Content-Type: application/json" \
  -d '{"age": 30, "gender": "male", "region": "US-East", "surveyID": "1234", "score": 4}'
```

---

## 🧪 Testing the Application

Use the provided `test_script.py` to post 10 requests for testing purposes.

---

### 📁 Project Structure

```
survey-management-api/
│
├── src/                   # Application source code
├── Dockerfile             # Docker configuration
├── test_script.py         # Script for API testing
├── pom.xml                # Maven configuration
└── README.md              # Project documentation
```

---

## 📝 Notes

- Ensure ports are available before running.
- `~/.oci` is mounted in Docker to access necessary configurations (e.g., for OCI SDK).

---

## 🤝 Contributing

Feel free to fork this repo, improve the project and make a pull request. Feedback and contributions are welcome!
