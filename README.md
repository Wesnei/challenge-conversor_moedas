
# 💱 Currency Converter

## 📖 Overview

The **Currency Converter** is a Java-based command-line application that converts amounts between various currencies using the [exchangerate-api.com](https://www.exchangerate-api.com) API. It features an interactive menu for selecting currency pairs (e.g., USD to BRL, ARS, or COP) and inputting amounts.

After each conversion, the program pauses, allowing users to review the result before returning to the main menu.

---

## 🚀 Features

- ✅ Supports conversion between:
  - US Dollar (USD) ↔ Brazilian Real (BRL)
  - US Dollar (USD) ↔ Argentine Peso (ARS)
  - US Dollar (USD) ↔ Colombian Peso (COP)
- ✅ User-friendly command-line interface with a clear menu
- ✅ Pauses after each conversion
- ✅ Error handling for invalid inputs and API issues

---

## 📦 Prerequisites

- **Java 11** or higher
- **Internet Connection**
- **API Key** from [exchangerate-api.com](https://www.exchangerate-api.com)
- **JSON Library**: [`org.json`](https://mvnrepository.com/artifact/org.json/json)

---

## 🛠️ Installation

### Step 1: Clone the Repository

```bash
git clone https://github.com/Wesnei/challenge-conversor_moedas.git
````

### Step 2: Add the JSON Library

#### Option 1: Manual Download

* Download the `org.json` JAR from [here](https://mvnrepository.com/artifact/org.json/json)
* Add the `.jar` to your project's classpath.

#### Option 2: Maven

Add to your `pom.xml`:

```xml
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20231013</version>
</dependency>
```

### Step 3: Configure the API Key

#### Option 1: Hardcoded (not recommended for production)

Edit `ConversorMoeda.java`:

```java
private static final String ACCESS_KEY = "YOUR_API_KEY_HERE";
```

#### Option 2: Environment Variable (recommended)

Set the variable:

```bash
export EXCHANGERATE_API_KEY=your_api_key_here
```

Update `ConversorMoeda.java`:

```java
String ACCESS_KEY = System.getenv("EXCHANGERATE_API_KEY");
if (ACCESS_KEY == null) {
    throw new IllegalStateException("API key not configured. Set the EXCHANGERATE_API_KEY environment variable.");
}
```

---

## ▶️ Usage

### Compile the Project

```bash
javac *.java
```

### Run the Application

```bash
java MenuConversor
```

### Example Menu

```
*******************************************
 Welcome to the Currency Converter =]
*******************************************
1) US Dollar => Argentine Peso
2) Argentine Peso => US Dollar
3) US Dollar => Brazilian Real
4) Brazilian Real => US Dollar
5) US Dollar => Colombian Peso
6) Colombian Peso => US Dollar
7) Exit
Choose a valid option:
```

After entering an amount, the program displays the result like:

```
Value 100.00 [USD] corresponds to the final value of >>> 567.380000 [BRL]
Press Enter to return to the menu...
```

Choose option 7 to exit the program.

---

## 📁 Project Structure

```
currency-converter/
├── MenuConversor.java        # Menu interface and user interaction
└── ConversorMoeda.java       # Currency conversion logic and API integration
```

---

## 📚 Dependencies

* Java 11+
* [org.json](https://mvnrepository.com/artifact/org.json/json)
* [exchangerate-api.com](https://www.exchangerate-api.com) (API)

---

## ⚠️ Limitations

* Free API plan: 100 requests/month
* Requires an active internet connection
* Only supports a limited set of currency pairs (USD ↔ BRL, ARS, COP)

---

## 🛠️ Troubleshooting

* **`missing_access_key`**: Ensure your API key is properly set.
* **`result field not found`**: Check the full API response printed in the console.
* **Connection errors**: Check internet connection and API endpoint availability.

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a feature branch:

```bash
git checkout -b feature/new-feature
```

3. Commit your changes:

```bash
git commit -m 'Add new feature'
```

4. Push to GitHub:

```bash
git push origin feature/new-feature
```

5. Open a **Pull Request**

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 📬 Contact

For questions or support, contact: `wesneipaiva@gmail.com`
