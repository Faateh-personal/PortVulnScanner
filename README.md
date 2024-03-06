# PortVulnScanner

PortVulnScanner is a Java-based tool for scanning network ports and checking for known vulnerabilities. It provides a simple command-line interface for users to specify the target IP address and port range for scanning.

## Features

- Scans a range of ports on a target IP address to identify open ports.
- Checks open ports for known vulnerabilities based on a predefined list.
- Provides a command-line interface for user input and output.

## Prerequisites

- Java 11 or later
- Maven (for building the project)

## Building the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/PortVulnScanner.git
   ```

2. Navigate to the project directory:

   ```bash
   cd PortVulnScanner
   ```

3. Build the project using Maven:

   ```bash
   mvn clean package
   ```

This will generate a `PortVulnScanner.jar` file in the `target` directory.

## Running the Application

Run the application using the following command:

```bash
java -jar target/PortVulnScanner.jar
```

Follow the prompts to enter the target IP address and port range for scanning.

## Docker Support

The project includes a Dockerfile for building and running the application in a Docker container.

1. Build the Docker image:

   ```bash
   docker build -t portvulnscanner .
   ```

2. Run the container:

   ```bash
   docker run --rm -it portvulnscanner
   ```

## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues to improve the project.
