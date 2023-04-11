# Stevie Wonder [![Build Status](https://img.shields.io/travis/MarcelleBond/stevie_wonder.svg?style=flat-square)](https://travis-ci.org/MarcelleBond/stevie_wonder)

Stevie Wonder is an OCR desktop application written in Java, using JFormDesigner for the UI. This OCR app connects to Google Cloud Vision using Maven libraries and uses an SQLite database to store the extracted text.

## Features

- Extracts text from images
- Supports image formats: JPEG, PNG, GIF, BMP, PDF
- Displays extracted text in the UI
- Option to save extracted text to a text file
- Stores extracted text in an SQLite database

## Installation

1. Install Java, Maven and SQLite
2. Clone the Stevie Wonder repository
3. Navigate to the repository in your terminal or command prompt
4. Run the following command: `mvn clean install`
5. After successful build, navigate to the `target` directory
6. Run the Stevie Wonder application: `java -jar StevieWonder.jar`

## Usage

1. Launch the Stevie Wonder application
2. Click the `Add Images` button to select an image file
3. Click the `Get All Text` button to extract text from the selected image
4. The extracted text will be displayed in the UI
6. The extracted text is also stored in the SQLite database

## Latest Release

The latest release can be found on the [releases page](https://github.com/MarcelleBond/stevie_wonder/releases/latest).

## Contributors

- [Marcelle Bond](https://github.com/MarcelleBond) - Author

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
