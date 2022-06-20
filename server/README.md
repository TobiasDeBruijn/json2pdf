# json2pdf
Convert a JSON description of a PDF document to a PDF document

## Installing
After starting the server, it'll listen on port 8080.

### Prebuild
Requirments:
- JRE 17

1. Download the latest version from [GitHub releases](https://github.com/TobiasDeBruijn/json2pdf/releases)
2. Run the jar: `java -jar <path to jar>`

### From source
Requirments:
- JDK 17
- Gradle 7

```shell
# Clone the repository
git clone https://github.com/TobiasDeBruijn/json2pdf.git
cd json2pdf/server

# Build the program
gradle bootJar

# Run the program (version suffix may differ)
java -jar build/libs/pdfgen-0.0.1.jar
```

# License
json2pdf is licensed under the Apache-2.0 license, or the MIT license. At your discretion. Both licenses can be found at the root of this repository.