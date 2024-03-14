# Usage

This section offers an overview of the `deta` library, designed to interact with Deta Base, a NoSQL database service. The library is presented as a tool for integration with Clojure projects, highlighting its benefits.

## Table of Contents

-  [Getting Started](#getting-started)
-  [Exemplified Usage](#exemplified-usage)
   -  [Database Connection Initialization](#database-connection-initialization)
   -  [Using the `put` Function](#using-the-put-function)
      -  [Basic Usage](#basic-usage)
      -  [Handling Non-Map Values](#handling-non-map-values)
      -  [Return Value and Exceptions](#return-value-and-exceptions)
      -  [Example with Non-Map Value](#example-with-non-map-value)
   -  [Using the `get` Function](#using-the-get-function)
      -  [Basic Usage](#basic-usage-1)
      -  [Return Value and Exceptions](#return-value-and-exceptions-1)
   -  [Using the `delete` Function](#using-the-delete-function)
      -  [Basic Usage](#basic-usage-2)
      -  [Return Value and Exceptions](#return-value-and-exceptions-2)
      -  [Example of Usage](#example-of-usage)
   -  [Using the `insert` Function](#using-the-insert-function)
      -  [Basic Usage](#basic-usage-3)
      -  [Handling Non-Map Values](#handling-non-map-values-1)
      -  [Return Value and Exceptions](#return-value-and-exceptions-3)
      -  [Example with Non-Map Value](#example-with-non-map-value-1)
   -  [Using the `fetch` Function](#using-the-fetch-function)
      -  [Basic Usage](#basic-usage-4)
      -  [Parameters](#parameters)
      -  [Example of Use](#example-of-use)
      -  [Return Value and Exceptions](#return-value-and-exceptions-4)
      -  [Example with Query Parameters](#example-with-query-parameters)
   -  [Use Cases](#use-cases)
      -  [Data Insertion](#data-insertion)
      -  [Data Retrieval](#data-retrieval)
      -  [Data Removal](#data-removal)
      -  [Data Fetching](#data-fetching)

<a name="getting-started"></a>

## Getting Started

To use the `deta.base` namespace, include it in your project dependencies and require it in your code. The namespace utilizes `clojure.string`, `clojure.data.json`, and `clj-http.client` for its operations.

```clojure
(ns your-namespace
 (:require [deta.base :as base]))
```

<a name="exemplified-usage"></a>

## Exemplified Usage

<a name="database-connection-initialization"></a>

### Database Connection Initialization

```clojure
(def db (base/base "a0abcyxzxsr_aSecretValue" "items"))
```

<a name="using-the-put-function"></a>

### Using the `put` Function

<a name="basic-usage"></a>

#### Basic Usage

```clojure
(base/put db {:a 1 :b 2} "item-key")
(base/put db {:a 1 :b 2}) ; The key is automatically generated on the server
```

<a name="handling-non-map-values"></a>

#### Handling Non-Map Values

If the data passed to the `put` function is not a map, it is automatically encapsulated in a map with the key `"value"`. This allows for flexibility in the types of data that can be stored in the database.

<a name="return-value-and-exceptions"></a>

#### Return Value and Exceptions

The `put` function returns a map containing the inserted data. If a key is not provided, the server automatically generates one. The returned map includes the data and the generated key.

The `put` function throws an `Exception` if the data type is not supported, or if the `deta-key` is invalid or not provided.

<a name="example-with-non-map-value"></a>

#### Example with Non-Map Value

```clojure
(base/put db "Hello, World!") ; Automatically encapsulated in {"value" "Hello, World!"}
```

<a name="using-the-get-function"></a>

### Using the `get` Function

<a name="basic-usage-1"></a>

#### Basic Usage

```clojure
(base/get db "item-key")
```

<a name="return-value-and-exceptions-1"></a>

#### Return Value and Exceptions

The `get` function returns a map containing the retrieved data if the key exists, or `nil` if the key does not exist or an error occurs.

The `get` function throws an `Exception` if the `deta-key` is invalid or not provided, or if the key is empty or not provided.

<a name="using-the-delete-function"></a>

### Using the `delete` Function

<a name="basic-usage-2"></a>

#### Basic Usage

```clojure
(base/delete db "item-key")
```

<a name="return-value-and-exceptions-2"></a>

#### Return Value and Exceptions

The `delete` function does not return a meaningful value, as its purpose is to remove an item from the database. If the provided key is `nil` or empty, the function will throw an exception. Otherwise, it attempts to delete the item corresponding to the provided key.

The `delete` function throws an `Exception` if the project key is not provided or is invalid.

<a name="example-of-usage"></a>

#### Example of Usage

```clojure
(base/delete db "user-123") ; Attempts to delete the item with the key "user-123"
```

<a name="using-the-insert-function"></a>

### Using the `insert` Function

<a name="basic-usage-3"></a>

#### Basic Usage

```clojure
(base/insert db {:a 1 :b 2} "item-key")
(base/insert db {:a 1 :b 2}) ; The key is automatically generated on the server
```

<a name="handling-non-map-values-1"></a>

#### Handling Non-Map Values

If the data passed to the `insert` function is not a map, it is automatically encapsulated in a map with the key `"value"`. This allows for flexibility in the types of data that can be stored in the database.

<a name="return-value-and-exceptions-3"></a>

#### Return Value and Exceptions

The `insert` function returns a map containing the inserted data. If a key is not provided, the server automatically generates one. The returned map includes the data and the generated key.

The `insert` function throws an `Exception` if an item with the provided key already exists (status code 409), or if the data type is not supported, or if the `deta-key` is invalid or not provided.

<a name="example-with-non-map-value-1"></a>

#### Example with Non-Map Value

```clojure
(base/insert db "Hello, World!") ; Automatically encapsulated in {"value" "Hello, World!"}
```

<a name="using-the-fetch-function"></a>

### Using the `fetch` Function

The `fetch` function is a powerful tool for performing custom queries on the Deta Base. It supports pagination, sorting, and limiting results, making it ideal for efficiently retrieving large sets of data.

<a name="basic-usage-4"></a>

#### Basic Usage

```clojure
(base/fetch db)
(base/fetch db query)
(base/fetch db query parameters)
```

-  `db`: The database connection object.
-  `query`: A list of queries or a single query as a string. If is empty returns all results from database. Read the [Deta Base documentation](https://deta.space/docs/en/build/reference/deta-base/queries) to know more about queries.
-  `parameters`: A map of parameters that can include `:limit`, `:last` and `:desc`.

<a name="parameters"></a>

#### Parameters

-  `:limit`: The maximum number of items to be returned. The default is 1000.
-  `:last`: The key of the last item from the last query, used for pagination. The default is `nil`.
-  `:desc`: A boolean indicating whether the sorting should be descending. The default is `false`.

<a name="example-of-use"></a>

#### Example of Use

```clojure
(base/fetch db {:name "John Doe"}) ; Basic query
(base/fetch db {:age 30} {:limit 10 :last "key"}) ; Query with limit and last
(base/fetch db {:age?r [22, 30]} {:limit 10 :desc true}) ; Query with limit and sorting mode
(base/fetch db) ; Fetching all results from current Deta Base
(base/fetch db {} {:limit 1 :last "deta-is-awesome"}) ; Fetching the first result starting from the key "deta-is-awesome"
```

Read the [Deta Base documentation](https://deta.space/docs/en/build/reference/deta-base/queries) to know more about queries.

<a name="return-value-and-exceptions-4"></a>

#### Return Value and Exceptions

The `fetch` function returns a map containing the number of items found (`:count`), the key of the last item (`:last`), and the list of found items (`:items`). If an error occurs during the query, the function will return a map with `:count` 0, `:last` `nil`, and `:items` an empty list.

<a name="example-with-query-parameters"></a>

#### Example with Query Parameters

```clojure
(base/fetch db [{:age?gt 30} {:name "Gulliver"}] {:limit 10 :desc true})
; Returns: {:count 5 :last "user-123" :items [{:name "Gulliver" :age 35} ...]}
```

<a name="use-cases"></a>

### Use Cases

<a name="data-insertion"></a>

#### Data Insertion

The `put` function's ability to accept any type of data makes it versatile for various use cases. Here are examples of inserting various types of data:

```clojure
(base/put db {:name "John Doe" :age 30}) ; Inserting a map
(base/put db "Hello, World!") ; Inserting a string
(base/put db 42) ; Inserting an integer
(base/put db 3.14) ; Inserting a float
(base/put db true) ; Inserting a boolean
(base/put db nil) ; Inserting nil
```

You can also use the `base/insert` command to insert data. The difference between `base/put` and `base/insert` is that `base/put` will insert data and update if the key already exists, while `base/insert` will throw an exception if the key already exists.

```clojure
(base/insert db {:name "John Doe" :age 30}) ; Inserting a map
(base/insert db "Hello, World!") ; Inserting a string
(base/insert db 42) ; Inserting an integer
(base/insert db 3.14) ; Inserting a float
(base/insert db true) ; Inserting a boolean
(base/insert db nil) ; Inserting nil
```

<a name="data-retrieval"></a>

#### Data Retrieval

To retrieve data from the database, you can use the `get` function. Here's an example of how to retrieve an item by its key:

```clojure
(base/get db "user-123")
```

<a name="data-removal"></a>

#### Data Removal

The `delete` function is useful for removing specific items from the database. Here's an example of how you can use this function to remove an item:

```clojure
(base/delete db "item-key") ; Removes the item with the key "item-key"
```

<a name="data-fetching"></a>

#### Data Fetching

To fetching data from the Deta Base, you can use the `fetch` function. Here's an example of how to fetch an item by its name:

```clojure
(base/fetch db {:name "John Doe"})
```
