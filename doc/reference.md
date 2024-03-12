# Reference

## Table of Contents

-   [`base`](#base)
-   [`put`](#put)
-   [`get`](#get)

## Base

```clojure
(base/base deta-key basename)
```

-   **Return:** Database connection object.
-   **Exceptions:** If `deta-key` is invalid or not provided.

## Put

```clojure
(base/put db data)
(base/put db data key)
```

-   **Return:** Map containing the inserted data and the generated key (if not provided).
-   **Exceptions:** If data type is not supported, or if `deta-key` is invalid or not provided.

## Get

```clojure
(base/get db key)
```

-   **Return:** Retrieved data as a map if the key exists, or `nil` if the key does not exist or an error occurs.
-   **Exceptions:** If `key` is not provided or is empty.
