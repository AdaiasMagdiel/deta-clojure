# Change Log

## [0.0.1] - 2024-03-11

### Added

-   Initial project setup with Clojure namespace and required dependencies.
-   Basic structure for Deta database operations, including `base` and `put` functions.
-   Initial implementation of `base` function to validate and construct a base URL for Deta database operations.
-   `put` function to insert data into a Deta database, with support for optional key and handling of different data types.
-   Refined error handling in `base` function to provide more specific error messages.
-   Enhanced `put` function to handle different data formats and include an optional key for data items.

[0.0.1]: https://github.com/AdaiasMagdiel/deta-clojure/commits/v0.0.1

## [0.0.2] - 2024-03-11

### Added

-   Initial project setup with Clojure namespace and required dependencies.
-   Basic structure for Deta database operations, including `base` and `put` functions.
-   Initial implementation of `base` function to validate and construct a base URL for Deta database operations.
-   `put` function to insert data into a Deta database, with support for optional key and handling of different data types.
-   Refined error handling in `base` function to provide more specific error messages.
-   Enhanced `put` function to handle different data formats and include an optional key for data items.
-   Documentation for installation, getting started, example usage, and testing.
-   New `get` function to retrieve data from the Deta database.
-   Test cases for `get` function to ensure reliability and correctness.

### Changed

-   Updated installation instructions to include Leiningen/Boot, Clojure CLI/deps.edn, Gradle, and Maven methods.
-   Simplified the process of initializing a database connection by providing a single example.
-   Improved error handling in `put` function to better manage invalid inputs and server responses.
-   Updated the `base` function to include `:throw-exceptions false` in the request headers, preventing exceptions from being thrown on server errors.

### Removed

-   Removed redundant installation instructions from the README.
-   Removed outdated or unused code snippets and examples.

[0.0.2]: https://github.com/AdaiasMagdiel/deta-clojure/compare/v0.0.1...v0.0.2
