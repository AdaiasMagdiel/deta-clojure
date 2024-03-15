# Deta Clojure Library

[![Clojars Project](https://img.shields.io/clojars/v/com.adaiasmagdiel/deta.svg)](https://clojars.org/com.adaiasmagdiel/deta)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Documentation](https://img.shields.io/badge/MKDocs-Documentation-green.svg)](https://adaiasmagdiel.github.io/deta-clojure/)

Deta is a Clojure library designed to simplify interactions with the Deta database. It provides a straightforward way to initialize a database connection and perform basic operations such as inserting data. This library is ideal for developers looking to integrate Deta database functionality into their Clojure applications.

## Table of Contents

-  [Project Progress](#project-progress)
   -  [Deta Base](#deta-base)
   -  [Deta Drive](#deta-drive)
-  [Features](#features)
-  [Installation](#installation)
   -  [Leiningen/Boot](#leiningenboot)
   -  [Clojure CLI/deps.edn](#clojure-clidepsedn)
   -  [Gradle](#gradle)
   -  [Maven](#maven)
-  [Tests](#tests)
   -  [Running Tests](#running-tests)
   -  [Windows](#windows)
   -  [Linux/MacOS](#linuxmacos)
-  [Usage](./usage.md)
   -  [Getting Started](./usage.md#getting-started)
   -  [Exemplified Usage](./usage.md#exemplified-usage)
      -  [Database Connection Initialization](./usage.md#database-connection-initialization)
      -  [Using the `put` Function](./usage.md#using-the-put-function)
         -  [Basic Usage](./usage.md#basic-usage)
         -  [Handling Non-Map Values](./usage.md#handling-non-map-values)
         -  [Return Value and Exceptions](./usage.md#return-value-and-exceptions)
         -  [Example with Non-Map Value](./usage.md#example-with-non-map-value)
      -  [Using the `get` Function](./usage.md#using-the-get-function)
         -  [Basic Usage](./usage.md#basic-usage-1)
         -  [Return Value and Exceptions](./usage.md#return-value-and-exceptions-1)
      -  [Using the `delete` Function](./usage.md#using-the-delete-function)
         -  [Basic Usage](./usage.md#basic-usage-2)
         -  [Return Value and Exceptions](./usage.md#return-value-and-exceptions-2)
         -  [Example of Usage](./usage.md#example-of-usage)
      -  [Using the `insert` Function](./usage.md#using-the-insert-function)
         -  [Basic Usage](./usage.md#basic-usage-3)
         -  [Handling Non-Map Values](./usage.md#handling-non-map-values-1)
         -  [Return Value and Exceptions](./usage.md#return-value-and-exceptions-3)
         -  [Example with Non-Map Value](./usage.md#example-with-non-map-value-1)
      -  [Using the `fetch` Function](./usage.md#using-the-fetch-function)
         -  [Basic Usage](./usage.md#basic-usage-4)
         -  [Parameters](./usage.md#parameters)
         -  [Example of Use](./usage.md#example-of-use)
         -  [Return Value and Exceptions](./usage.md#return-value-and-exceptions-4)
         -  [Example with Query Parameters](./usage.md#example-with-query-parameters)
      -  [Use Cases](./usage.md#use-cases)
         -  [Data Insertion](./usage.md#data-insertion)
         -  [Data Retrieval](./usage.md#data-retrieval)
         -  [Data Removal](./usage.md#data-removal)
         -  [Data Fetching](./usage.md#data-fetching)
-  [Reference](./reference.md)
   -  [Base](./reference.md#base)
   -  [Put](./reference.md#put)
   -  [Get](./reference.md#get)
   -  [Delete](./reference.md#delete)
   -  [Insert](./reference.md#insert)
   -  [Fetch](./reference.md#fetch)

## Project Progress

The current focus is on implementing functions for Deta Base, with Deta Drive functionalities yet to be started.

### Deta Base

The Deta Base API provides a range of functionalities for data manipulation. The following functions have been implemented:

-  [x] **Base Object**: Creation and configuration of the base object for API interaction.
-  [x] **Put**: Insertion of an object into the database.
-  [x] **Get**: Retrieval of a specific object from the database.
-  [x] **Insert**: Insertion of a new object into the database.
-  [x] **Fetch**: Retrieval of objects based on specific criteria.
-  [x] **Delete**: Removal of an object from the database.

The remaining functions to be implemented are:

-  [ ] **Put Many**: Insertion of multiple objects into the database at once.
-  [ ] **Update**: Update of an existing object in the database.

### Deta Drive

Deta Drive offers functionalities for file storage and manipulation. As of now, work on Deta Drive functionalities has not yet begun. The planned functionalities include:

-  [ ] **Drive Object**: Creation and configuration of the drive object for API interaction.
-  [ ] **Put**: Upload of a file to Deta Drive.
-  [ ] **Get**: Download of a specific file from Deta Drive.
-  [ ] **Delete**: Removal of a file from Deta Drive.
-  [ ] **List**: Listing of available files in Deta Drive.
-  [ ] **Delete Many**: Removal of multiple files from Deta Drive at once.

This project is under continuous development, with the goal of providing a robust and efficient solution for interacting with the Deta Space API in Clojure. Follow the progress and contribute with suggestions or implementations of new functionalities.

## Features

-  **Database Initialization**: Easily establish a connection to a Deta database with a straightforward function call.
-  **Data Insertion**: Insert data into the Deta database, supporting various data types.
-  **Data Update**: Update existing data in the Deta database or insert new data if the key does not exist.
-  **Data Retrieval**: Fetch data from the Deta database by specifying a key.
-  **Data Deletion**: Remove data from the Deta database by specifying a key.
-  **Testing**: A comprehensive test suite is essential to ensure reliability and accuracy.

<a name="installation"></a>

## Installation

<a name="leiningenboot"></a>

### Leiningen/Boot

Add the following dependency to your `project.clj`:

```clojure
[com.adaiasmagdiel/deta "0.0.5"]
```

<a name="clojure-clidepsedn"></a>

### Clojure CLI/deps.edn

Add the following dependency to your `deps.edn`:

```clojure
com.adaiasmagdiel/deta {:mvn/version "0.0.5"}
```

<a name="gradle"></a>

### Gradle

Add the following dependency to your `build.gradle`:

```gradle
implementation("com.adaiasmagdiel:deta:0.0.5")
```

<a name="maven"></a>

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
 <groupId>com.adaiasmagdiel</groupId>
 <artifactId>deta</artifactId>
 <version>0.0.5</version>
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
