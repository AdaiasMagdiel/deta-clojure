# Deta Clojure Library

[![Clojars Project](https://img.shields.io/clojars/v/com.adaiasmagdiel/deta.svg)](https://clojars.org/com.adaiasmagdiel/deta)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Documentation](https://img.shields.io/badge/MKDocs-Documentation-green.svg)](https://adaiasmagdiel.github.io/deta-clojure/)

Deta is a Clojure library designed to simplify interactions with the Deta Base and Deta Drive. It provides a straightforward way to initialize a service connection and perform operations. This library is ideal for developers looking to integrate Deta Space services functionality into their Clojure applications.

## Table of Contents

-   [Project Progress](#project-progress)
    -   [Deta Base](#deta-base)
    -   [Deta Drive](#deta-drive)
-   [Features](#features)
-   [Documentation](#documentation)
-   [Getting Started](#getting-started)
    -   [Prerequisites](#prerequisites)
    -   [Installation](#installation)
    -   [Simple Usage](#simple-usage)
        -   [Initializing a Deta Base Connection](#initializing-a-deta-base-connection)
        -   [Inserting Data](#inserting-data)
        -   [Retrieving Data](#retrieving-data)
        -   [Deleting Data](#deleting-data)
        -   [Fetching Data](#deleting-data)
-   [Testing](#testing)
    -   [Windows](#windows)
    -   [Linux/MacOS](#linuxmacos)
-   [Contributing](#contributing)
-   [License](#license)
-   [Contact](#contact)

## Project Progress

The current focus is on implementing functions for Deta Base, with Deta Drive functionalities yet to be started.

### Deta Base

The Deta Base API provides a range of functionalities for data manipulation. The following functions have been implemented:

-   [x] **Base Object**: Creation and configuration of the base object for API interaction.
-   [x] **Put**: Insertion of an object into the database.
-   [x] **Get**: Retrieval of a specific object from the database.
-   [x] **Insert**: Insertion of a new object into the database.
-   [x] **Fetch**: Retrieval of objects based on specific criteria.
-   [x] **Delete**: Removal of an object from the database.
-   [x] **Update**: Update of an existing object in the database.

The remaining functions to be implemented are:

-   [ ] **Put Many**: Insertion of multiple objects into the database at once.

### Deta Drive

Deta Drive offers functionalities for file storage and manipulation. As of now, work on Deta Drive functionalities has not yet begun. The planned functionalities include:

-   [ ] **Drive Object**: Creation and configuration of the drive object for API interaction.
-   [ ] **Put**: Upload of a file to Deta Drive.
-   [ ] **Get**: Download of a specific file from Deta Drive.
-   [ ] **Delete**: Removal of a file from Deta Drive.
-   [ ] **List**: Listing of available files in Deta Drive.
-   [ ] **Delete Many**: Removal of multiple files from Deta Drive at once.

This project is under continuous development, with the goal of providing a robust and efficient solution for interacting with the Deta Space API in Clojure. Follow the progress and contribute with suggestions or implementations of new functionalities.

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
[com.adaiasmagdiel/deta "0.0.5"]
```

For more installation methods, such as `Clojure CLI/deps.edn`, `Gradle`, and `Maven`, please refer to the [installation](https://adaiasmagdiel.github.io/deta-clojure/#installation) section of our documentation.

### Simple Usage

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

#### Fetching Data

```clojure
(base/fetch db) ; Fetch all records
(base/fetch db {:name "Jane Doe"}) ; Fetch only records with name = "Jane Doe"
(base/fetch db {:name "Jane Doe"} {:limit 1 :desc true}) ; Use parameters to modify fetching
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
