# Reference

## Table of Contents

- [Base](#base)
- [Put](#put)
- [Get](#get)
- [Delete](#delete)
- [Insert](#insert)

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
