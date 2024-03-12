# Deta Clojure Library

[![Clojars Project](https://img.shields.io/clojars/v/com.adaiasmagdiel/deta.svg)](https://clojars.org/com.adaiasmagdiel/deta)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Deta is a Clojure library designed to simplify interactions with the Deta database. It provides a straightforward way to initialize a database connection and perform basic operations such as inserting data. This library is ideal for developers looking to integrate Deta database functionality into their Clojure applications.

## Features

-   **Base Initialization**: Easily initialize a database connection with a simple function call.
-   **Data Insertion**: Insert data into the Deta database with support for various data types.
-   **Testing**: Comprehensive test suite to ensure reliability and correctness.

## Documentation

-   [Introduction](doc/intro.md)
-   [Usage](doc/usage.md)
-   [Reference](doc/reference.md)

## Getting Started

### Prerequisites

-   Clojure 1.10 or later
-   Leiningen 2.9.1 or later

### Installation

This library is now available as a dependency. You can add it to your project using Leiningen/Boot by including the following in your `project.clj` dependencies:

```clojure
[com.adaiasmagdiel/deta "0.0.1"]
```

For more installation methods, such as `Clojure CLI/deps.edn`, `Gradle`, and `Maven`, please refer to the [Installation](doc/usage.md#installation) section of our documentation.

### Usage

#### Initializing a Deta Base Connection

```clojure
(def db (base/base "your_collection_key" "your_basename"))
```

#### Inserting Data

```clojure
(base/put db {:a 1 :b 2} "item-key")
```

#### Retrieving Data

```clojure
(base/get db "item-key")
```

For more detailed usage instructions and examples, please refer to the [Usage](doc/usage.md#getting-started) section of our documentation.

## Testing

The library includes a test suite that covers various scenarios. To run the tests, set the `DETA_KEY` environment variable with a valid Deta key beforehand.

### Windows

```cmd
set DETA_KEY=your_deta_key_here
lein test
```

### Linux/MacOS

```bash
export DETA_KEY=your_deta_key_here
lein test
```

Replace `your_deta_key_here` with your actual Deta key.

## Contributing

Contributions are always welcome! Please review the code and send suggestions or pull requests to improve the library.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contact

For any questions or suggestions, please open an issue on GitHub.
