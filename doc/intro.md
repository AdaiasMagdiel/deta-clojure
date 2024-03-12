# Deta Base Documentation

This documentation provides an overview of the `deta.base` namespace, which is part of a Clojure project designed to interact with the Deta database. The namespace includes functions for initializing a database connection and performing basic operations such as inserting data.

## Table of Contents

1. [Introduction](./usage#introduction)
2. [Installation](./usage#installation)
    - [Leiningen/Boot](./usage#leiningenboot)
    - [Clojure CLI/deps.edn](./usage#clojure-clidedn)
    - [Gradle](./usage#gradle)
    - [Maven](./usage#maven)
3. [Getting Started](./usage#getting-started)
4. [Example Usage](./usage#example-usage)
    - [Initializing the Database Connection](./usage#initializing-the-database-connection)
    - [Using the `put` Function](./usage#using-the-put-function)
        - [Basic Usage](./usage#basic-usage)
        - [Handling Non-Map Values](./usage#handling-non-map-values)
        - [Return Value and Exceptions](./usage#return-value-and-exceptions)
    - [Using the `get` Function](./usage#using-the-get-function)
        - [Basic Usage](./usage#basic-usage-1)
        - [Return Value and Exceptions](./usage#return-value-and-exceptions-1)
    - [Use Cases](./usage#use-cases)
        - [Inserting Data](./usage#inserting-data)
        - [Retrieving Data](./usage#retrieving-data)
5. [Testing](./usage#testing)
6. [API Reference](./reference#api-reference)
    - [`base`](./reference#base)
    - [`put`](./reference#put)
    - [`get`](./reference#get)
