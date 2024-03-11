# Deta Base Clojure Library

[![Clojars Project](https://img.shields.io/clojars/v/com.adaiasmagdiel/deta.svg)](https://clojars.org/com.adaiasmagdiel/deta)

Deta Base is a Clojure library designed to simplify interactions with the Deta database. It provides a straightforward way to initialize a database connection and perform basic operations such as inserting data. This library is ideal for developers looking to integrate Deta database functionality into their Clojure applications.

## Features

-   **Base Initialization**: Easily initialize a database connection with a simple function call.
-   **Data Insertion**: Insert data into the Deta database with support for various data types.
-   **Testing**: Comprehensive test suite to ensure reliability and correctness.

## Getting Started

### Prerequisites

-   Clojure 1.10 or later
-   Leiningen 2.9.1 or later

### Installation

This library is now available as a dependency. You can add it to your project using one of the following methods:

#### Leiningen/Boot

Add the following to your `project.clj` dependencies:

```clojure
[com.adaiasmagdiel/deta "0.0.1"]
```

#### Clojure CLI/deps.edn

Add the following to your `deps.edn` dependencies:

```clojure
com.adaiasmagdiel/deta {:mvn/version "0.0.1"}
```

#### Gradle

Add the following to your `build.gradle` dependencies:

```gradle
implementation("com.adaiasmagdiel:deta:0.0.1")
```

#### Maven

Add the following to your `pom.xml` dependencies:

```xml
<dependency>
 <groupId>com.adaiasmagdiel</groupId>
 <artifactId>deta</artifactId>
 <version>0.0.1</version>
</dependency>
```

## Usage

### Initializing a Database Connection

To initialize a database connection, use the `base` function:

```clojure
(def db (base/base "your_collection_key" "your_basename"))
```

### Inserting Data

To insert data into the Deta database, use the `put` function:

```clojure
(base/put db {:a 1 :b 2} "item-key")
```

## Testing

The library includes a test suite that covers various scenarios. To run the tests, execute the following command in your project directory:

```bash
lein test
```

## Contributing

Contributions are welcome! Please read the [CONTRIBUTING.md](CONTRIBUTING.md) for details on how to contribute to this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

-   Deta for providing a powerful and scalable database solution.
-   The Clojure community for their support and contributions.

## Future Plans

-   Publish the library as a dependency for easier integration.
-   Expand the library with more advanced database operations.

## Contact

For any questions or suggestions, please open an issue on GitHub.
