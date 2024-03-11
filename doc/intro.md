# Deta Base Documentation

This documentation provides an overview of the `deta.base` namespace, which is part of a Clojure project designed to interact with the Deta database. The namespace includes functions for initializing a database connection and performing basic operations such as inserting data.

## Table of Contents

-   [Getting Started](#getting-started)
-   [Base Function](#base-function)
-   [Put Function](#put-function)
-   [Testing](#testing)

## Getting Started

To use the `deta.base` namespace, you need to include it in your project's dependencies and require it in your code. The namespace requires `clojure.string`, `clojure.data.json`, and `clj-http.client` for its operations.

```clojure
(ns your-namespace
 (:require [deta.base :as base]))
```

## Base Function

The `base` function is used to initialize a database connection. It takes two arguments: `deta-key` and `basename`. The `deta-key` is a string that identifies your Deta project and must be in the format `collection_key`. The `basename` is the name of the collection you want to interact with.

### Usage

```clojure
(def db (base/base "your_collection_key" "your_basename"))
```

### Example

```clojure
(def db (base/base "a0abcyxzxsr_aSecretValue" "items"))
```

## Put Function

The `put` function is used to insert data into the Deta database. It can accept a map, a string, a boolean, an integer, a float, or nil as data. Optionally, you can also provide a key for the data item.

### Usage

```clojure
(base/put db data)
(base/put db data key)
```

### Example

```clojure
(base/put db {:a 1 :b 2} "item-key")
```

## Testing

The `deta.base-test` namespace includes tests for both the `base` and `put` functions. These tests cover various scenarios, including valid and invalid `deta-key` inputs, different data types for the `put` function, and the behavior of the `put` function when a key is provided.

### Running Tests

To run the tests, execute the following command in your project directory:

```bash
lein test
```

## Conclusion

This documentation provides a basic overview of the `deta.base` namespace and its functions. For more detailed information, refer to the source code and the test cases provided.
