# Deta Clojure Library

[![Clojars Project](https://img.shields.io/clojars/v/com.adaiasmagdiel/deta.svg)](https://clojars.org/com.adaiasmagdiel/deta)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Documentation](https://img.shields.io/badge/MKDocs-Documentation-green.svg)](https://adaiasmagdiel.github.io/deta-clojure/)

Deta is a Clojure library designed to simplify interactions with the Deta database. It provides a straightforward way to initialize a database connection and perform basic operations such as inserting data. This library is ideal for developers looking to integrate Deta database functionality into their Clojure applications.

## Table of Contents

-   [Features](#features)
-   [Documentation](#documentation)
-   [Getting Started](#getting-started)
    -   [Prerequisites](#prerequisites)
    -   [Installation](#installation)
    -   [Usage](#usage)
        -   [Initializing a Deta Base Connection](#initializing-a-deta-base-connection)
        -   [Inserting Data](#inserting-data)
        -   [Retrieving Data](#retrieving-data)
        -   [Deleting Dataa](#deleting-data)
-   [Testing](#testing)
    -   [Windows](#windows)
    -   [Linux/MacOS](#linuxmacos)
-   [Contributing](#contributing)
-   [License](#license)
-   [Contact](#contact)

## Features

-   **Database Initialization**: Easily establish a connection to a Deta database with a straightforward function call.
-   **Data Insertion**: Insert data into the Deta database, supporting various data types.
-   **Data Update**: Update existing data in the Deta database or insert new data if the key does not exist.
-   **Data Retrieval**: Fetch data from the Deta database by specifying a key.
-   **Data Deletion**: Remove data from the Deta database by specifying a key.
-   **Testing**: A comprehensive test suite is essential to ensure reliability and accuracy.

## Documentation

To fully understand how to use this software, referring to the comprehensive documentation available at [https://adaiasmagdiel.github.io/deta-clojure/](https://adaiasmagdiel.github.io/deta-clojure/).

## Getting Started

### Prerequisites

-   Clojure 1.10 or later
-   Leiningen 2.9.1 or later

### Installation

This library is now available as a dependency. You can add it to your project using Leiningen/Boot by including the following in your `project.clj` dependencies:

```clojure
[com.adaiasmagdiel/deta "0.0.4"]
```

For more installation methods, such as `Clojure CLI/deps.edn`, `Gradle`, and `Maven`, please refer to the [installation](https://adaiasmagdiel.github.io/deta-clojure/#installation) section of our documentation.

### Usage

#### Initializing a Deta Base Connection

```clojure
(def db (base/base "your_collection_key" "your_basename"))
```

#### Inserting Data

```clojure
(base/put db {:a 1 :b 2} "item-key")
(base/put db {:c 3 :d 4}) ; The key is automatically generated on the server
```

```clojure
(base/insert db {:a 1 :b 2} "item-key")
(base/insert db {:c 3 :d 4}) ; The key is automatically generated on the server
```

Please refer to the [documentation](https://adaiasmagdiel.github.io/deta-clojure/usage/#data-insertion) to understand the distinction between "put" and "insert".

#### Retrieving Data

```clojure
(base/get db "item-key")
```

#### Deleting Data

```clojure
(base/delete db "item-key")
```

For more detailed usage instructions and examples, please refer to the [usage](https://adaiasmagdiel.github.io/deta-clojure/usage/#getting-started) section of our documentation.

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

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or suggestions, please open an issue on GitHub.
