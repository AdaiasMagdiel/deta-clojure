# Deta Base Documentation

This documentation provides an overview of the `deta.base` namespace, which is part of a Clojure project designed to interact with the Deta database. The namespace includes functions for initializing a database connection and performing basic operations such as inserting data.

## Table of Contents

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
    - [Use Cases](#use-cases)
        - [Inserting Data](#inserting-data)
        - [Retrieving Data](#retrieving-data)
5. [Testing](#testing)
6. [API Reference](#api-reference)
    - [`base`](#base)
    - [`put`](#put)
    - [`get`](#get)
