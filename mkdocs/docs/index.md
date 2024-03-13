# Deta Clojure API

This documentation provides an overview of the `deta.base` namespace, which is part of a Clojure project designed to interact with the Deta database. The namespace includes functions for initializing a database connection and performing basic operations such as inserting data.

## Table of Contents

- [Installation](#installation)
    - [Leiningen/Boot](#leiningenboot)
    - [Clojure CLI/deps.edn](#clojure-clidepsedn)
    - [Gradle](#gradle)
    - [Maven](#maven)
- [Tests](./usage.md#tests)
    - [Running Tests](./usage.md#running-tests)
    - [Windows](./usage.md#windows)
    - [Linux/MacOS](./usage.md#linuxmacos)
- [Usage](./usage.md)
    - [Getting Started](./usage.md#getting-started)
    - [Exemplified Usage](./usage.md#exemplified-usage)
       * [Database Connection Initialization](./usage.md#database-connection-initialization)
       * [Using the `put` Function](./usage.md#using-the-put-function)
          + [Basic Usage](./usage.md#basic-usage)
          + [Handling Non-Map Values](./usage.md#handling-non-map-values)
          + [Return Value and Exceptions](./usage.md#return-value-and-exceptions)
          + [Example with Non-Map Value](./usage.md#example-with-non-map-value)
       * [Using the `get` Function](./usage.md#using-the-get-function)
          + [Basic Usage](./usage.md#basic-usage-1)
          + [Return Value and Exceptions](./usage.md#return-value-and-exceptions-1)
       * [Using the `delete` Function](./usage.md#using-the-delete-function)
          + [Basic Usage](./usage.md#basic-usage-2)
          + [Return Value and Exceptions](./usage.md#return-value-and-exceptions-2)
          + [Example of Usage](./usage.md#example-of-usage)
       * [Using the `insert` Function](./usage.md#using-the-insert-function)
          + [Basic Usage](./usage.md#basic-usage-3)
          + [Handling Non-Map Values](./usage.md#handling-non-map-values-1)
          + [Return Value and Exceptions](./usage.md#return-value-and-exceptions-3)
          + [Example with Non-Map Value](./usage.md#example-with-non-map-value-1)
       * [Use Cases](./usage.md#use-cases)
          + [Data Insertion](./usage.md#data-insertion)
          + [Data Retrieval](./usage.md#data-retrieval)
          + [Data Removal](./usage.md#data-removal)
- [Reference](./reference.md)
    - [Base](./reference.md#base)
    - [Put](./reference.md#put)
    - [Get](./reference.md#get)
    - [Delete](./reference.md#delete)
    - [Insert](./reference.md#insert)

<a name="installation"></a>
## Installation

<a name="leiningenboot"></a>
### Leiningen/Boot

Add the following dependency to your `project.clj`:

```clojure
[com.adaiasmagdiel/deta "0.0.3"]
```

<a name="clojure-clidepsedn"></a>
### Clojure CLI/deps.edn

Add the following dependency to your `deps.edn`:

```clojure
com.adaiasmagdiel/deta {:mvn/version "0.0.3"}
```

<a name="gradle"></a>
### Gradle

Add the following dependency to your `build.gradle`:

```gradle
implementation("com.adaiasmagdiel:deta:0.0.3")
```

<a name="maven"></a>
### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
 <groupId>com.adaiasmagdiel</groupId>
 <artifactId>deta</artifactId>
 <version>0.0.3</version>
</dependency>
```

<a name="tests"></a>
## Tests

The `deta.base-test` namespace includes tests for the `base` and `put` functions. These tests cover various scenarios, including valid and invalid `deta-key` inputs, different data types for the `put` function, and the behavior of the `put` function when a key is provided.

<a name="running-tests"></a>
### Running Tests

To run the tests, set the `DETA_KEY` environment variable to a valid Deta key beforehand.

<a name="windows"></a>
### Windows

```cmd
set DETA_KEY=your_deta_key_here
lein test
```

<a name="linuxmacos"></a>
### Linux/MacOS

```bash
export DETA_KEY=your_deta_key_here
lein test
```

Replace `your_deta_key_here` with your actual Deta key.