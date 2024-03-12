# Usage

This documentation provides comprehensive guidance on how to use the `deta` library, a Clojure library designed to interact with the Deta Base, a NoSQL database service.

It covers installation, getting started, example usage, and testing. The documentation is structured to ensure users can easily navigate through the content and understand how to integrate and utilize the library in their projects.

# Table of Contents

1. [Introduction](#introduction)
2. [Installation](#installation)
    - [Leiningen/Boot](#leiningenboot)
    - [Clojure CLI/deps.edn](#clojure-clidedn)
    - [Gradle](#gradle)
    - [Maven](#maven)
3. [Getting Started](#getting-started)
4. [Example Usage](#example-usage)
    - [Initializing the Database Connection](#initializing-the-database-connection)
    - [Using the `put` Function](#using-the-put-function)
        - [Basic Usage](#basic-usage)
        - [Handling Non-Map Values](#handling-non-map-values)
        - [Return Value and Exceptions](#return-value-and-exceptions)
    - [Using the `get` Function](#using-the-get-function)
        - [Basic Usage](#basic-usage-1)
        - [Return Value and Exceptions](#return-value-and-exceptions-1)
    - [Using the `delete` Function](#using-the-delete-function)
    - [Use Cases](#use-cases)
        - [Inserting Data](#inserting-data)
        - [Retrieving Data](#retrieving-data)
5. [Testing](#testing)

## Introduction

This section provides an overview of the `deta` library and its purpose. It introduces the library as a tool for interacting with the Deta Base, a NoSQL database service, and outlines the benefits of using this library in Clojure projects.

## Installation

### Leiningen/Boot

Add the following to your `project.clj` dependencies:

```clojure
[com.adaiasmagdiel/deta "0.0.1"]
```

### Clojure CLI/deps.edn

Add the following to your `deps.edn` dependencies:

```clojure
com.adaiasmagdiel/deta {:mvn/version "0.0.1"}
```

### Gradle

Add the following to your `build.gradle` dependencies:

```gradle
implementation("com.adaiasmagdiel:deta:0.0.1")
```

### Maven

Add the following to your `pom.xml` dependencies:

```xml
<dependency>
 <groupId>com.adaiasmagdiel</groupId>
 <artifactId>deta</artifactId>
 <version>0.0.1</version>
</dependency>
```

## Getting Started

To use the `deta.base` namespace, you need to include it in your project's dependencies and require it in your code. The namespace use `clojure.string`, `clojure.data.json`, and `clj-http.client` for its operations.

```clojure
(ns your-namespace
 (:require [deta.base :as base]))
```

## Example Usage

### Initializing the Database Connection

```clojure
(def db (base/base "a0abcyxzxsr_aSecretValue" "items"))
```

### Using the `put` Function

#### Basic Usage

```clojure
(base/put db {:a 1 :b 2} "item-key")
(base/put db {:a 1 :b 2}) ; The key is automatically generated on the server
```

#### Handling Non-Map Values

If the data passed to the `put` function is not a map, it is automatically wrapped in a map with the key `"value"`. This allows for flexibility in the types of data that can be stored in the database.

#### Return Value and Exceptions

The `put` function returns a map containing the inserted data. If a key is not provided, the server automatically generates one. The returned map includes the data and the generated key.

The `put` function throws an `Exception` if the data type is not supported or if the `deta-key` is invalid or not provided.

#### Example with Non-Map Value

```clojure
(base/put db "Hello, World!") ; Automatically wrapped in {"value" "Hello, World!"}
```

### Using the `get` Function

#### Basic Usage

```clojure
(base/get db "item-key")
```

#### Return Value and Exceptions

The `get` function returns a map containing the retrieved data if the key exists, or `nil` if the key does not exist or an error occurs.

The `get` function throws an `Exception` if the `deta-key` is invalid or not provided, or if the key is empty or not provided.

### Using the `delete` Function

#### Basic Usage

```clojure
(base/delete db "item-key")
```

#### Return Value and Exceptions

The `delete` function does not return a meaningful value, as its purpose is to remove an item from the database. If the provided key is `nil` or empty, the function will throw an exception. Otherwise, it attempts to delete the item corresponding to the provided key.

The `delete` function throws an `Exception` if the project key is not provided or is invalid.

#### Example of Usage

```clojure
(base/delete db "user-123") ; Attempts to delete the item with the key "user-123"
```

### Use Cases

#### Inserting Data

The `put` function's ability to accept any data type makes it versatile for different use cases. Here are examples of inserting various data types:

```clojure
(base/put db {:name "John Doe" :age 30}) ; Inserting a map
(base/put db "Hello, World!") ; Inserting a string
(base/put db 42) ; Inserting an integer
(base/put db 3.14) ; Inserting a float
(base/put db true) ; Inserting a boolean
(base/put db nil) ; Inserting nil
```

#### Retrieving Data

To retrieve data from the database, you can use the `get` function. Here's an example of how to retrieve an item by its key:

```clojure
(base/get db "user-123")
```

#### Removing Data

The `delete` function is useful for removing specific items from the database. Here's an example of how you can use this function to remove an item:

```clojure
(base/delete db "item-key") ; Removes the item with the key "item-key"
```

## Testing

The `deta.base-test` namespace includes tests for both the `base` and `put` functions. These tests cover various scenarios, including valid and invalid `deta-key` inputs, different data types for the `put` function, and the behavior of the `put` function when a key is provided.

### Running Tests

To run the tests, set the `DETA_KEY` environment variable with a valid Deta key beforehand.

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
