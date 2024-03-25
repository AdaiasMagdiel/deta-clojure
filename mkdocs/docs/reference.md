# Reference

## Table of Contents

-   [Base](#base)
-   [Put](#put)
-   [Get](#get)
-   [Delete](#delete)
-   [Insert](#insert)
-   [Fetch](#fetch)
-   [Update](#update)

<a name="base"></a>

## Base

```clojure
(base/base deta-key basename)
```

-   **Return:** Database connection object.
-   **Exceptions:** If `deta-key` is invalid or not provided.

<a name="put"></a>

## Put

```clojure
(base/put db data)
(base/put db data key)
```

-   **Return:** Map containing the inserted data and the generated key (if not provided).
-   **Exceptions:** If data type is not supported, or if `deta-key` is invalid or not provided.

<a name="get"></a>

## Get

```clojure
(base/get db key)
```

-   **Return:** Retrieved data as a map if the key exists, or `nil` if the key does not exist or an error occurs.
-   **Exceptions:** If `key` is not provided or is empty.

<a name="delete"></a>

## Delete

```clojure
(base/delete db key)
```

-   **Return:** `nil`. The function does not return a meaningful value as its purpose is to remove an item from the database.
-   **Exceptions:** Throws an `Exception` if the key is not provided or is empty.

<a name="insert"></a>

## Insert

```clojure
(base/insert db data)
(base/insert db data key)
```

-   **Return:** Map containing the inserted data and the generated key (if not provided).
-   **Exceptions:** Throws an `Exception` if the data type is not supported, or if `deta-key` is invalid or not provided, or if an item with the provided key already exists.

<a name="fetch"></a>

## Fetch

```clojure
(base/fetch db)
(base/fetch db query)
(base/fetch db query parameters)
```

-   **Parameters:**

    -   `db`: The database connection object.
    -   `query`: A string or list of strings representing the query to be executed.
    -   `parameters`: A map containing additional query parameters, including `limit`, `last`, and `desc`.

-   **Return:** A map containing the number of items found (`:count`), the last key queried (`:last`), and a list of the items found (`:items`). If the query fails, it returns a map with `:count` 0, `:last` `nil`, and `:items` an empty list.

<a name="update"></a>

## Update

```clojure
(base/update db key updates)
```

-   **Parameters:**
-   `db`: The database connection object.
-   `key`: The key of the item to be updated.
-   `updates`: A map containing the updates to be applied to the item. Please refer to the [Deta Base documentation](https://deta.space/docs/en/build/reference/http-api/base#update-item) to know more.

-   **Return:** `nil`. The function does not return a meaningful value as its purpose is to update an item in the database.

-   **Exceptions:** Throws an `Exception` if the key is not provided or is empty, if there is no item with the provided key, or the payload is incorrect or malformatted.
