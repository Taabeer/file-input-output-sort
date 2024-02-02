# file-input-output-sort
### Introduction
Fail2Ban is a Java program designed to parse log files for invalid IP addresses and identify potential malicious behavior. It identifies instances where an IP address has been marked as "Invalid" multiple times within the log file and outputs these suspicious addresses to a separate file for further analysis or action.

### Features
- Parses log files to identify invalid IP addresses.
- Detects instances where an IP address appears three or more times consecutively.
- Outputs suspicious IP addresses to a separate file.

### Prerequisites
- Java Development Kit (JDK) installed on your system.
- Basic understanding of command-line interface.

### Installation
1. Clone or download the repository to your local machine.
2. Compile the Java source code using the following command:
   ```bash
   javac Fail2Ban.java

### Usage
1. Replace inputLogFile.txt with the path to the log file you want to analyze.
2. Replace outputLogFile.txt with the desired filename for the output file.
3. Execute the program with the following command:
   ```bash
   javac Fail2Ban.java
### Functionality
The program reads the contents of the specified input log file.
It identifies lines containing the keyword "Invalid" and extracts the corresponding IP addresses.
If an IP address appears three or more times consecutively, it is considered suspicious.
Suspicious IP addresses are written to the specified output log file for further examination.
