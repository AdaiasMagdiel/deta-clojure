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

## [0.0.3] - 2024-03-12

### Added

-   Added new sections to `README.md` for documentation structure and updated links to reflect the new documentation paths.
-   Introduced `base/insert` function for inserting data into the database with optional key specification.
-   Added `base/delete` function for removing items from the database by key.
-   Updated documentation in `doc/intro.md`, `doc/reference.md`, and `doc/usage.md` to include the new `insert` and `delete` functions.
-   Added tests for `base/delete` and `base/insert` functions in `test/deta/base_test.clj`.

### Changed

-   Updated the `base` function to simplify the condition for checking the validity of the `deta-key`.
-   Updated the `get` function to use a more concise condition for checking the validity of the key.
-   Updated the `README.md` to correct the installation instructions and to include a note on setting the `DETA_KEY` environment variable for testing.
-   Updated the documentation in `doc/usage.md` to include detailed usage examples for the `delete` and `insert` functions.
-   Updated the `test/deta/base_test.clj` to include tests for the `delete` and `insert` functions.

### Removed

-   Removed the old documentation structure references from `README.md`.
-   Removed the old `base/put` function documentation from `doc/reference.md`.

[0.0.3]: https://github.com/AdaiasMagdiel/deta-clojure/compare/v0.0.2...v0.0.3

## [0.0.4] - 2024-03-13

### Added

-   Added a new function `fetch` to the `base.clj` file, allowing for custom queries to the Deta database with support for pagination, sorting, and limiting results.
-   Added tests for the `fetch` function in the `base_test.clj` file, covering various scenarios such as valid and non-matching queries, handling multiple queries, and pagination.
-   Added a new section to the README.md file for documentation, including a link to the project's documentation hosted on GitHub Pages.
-   Added a new section to the README.md file for a table of contents, improving the navigation of the documentation.
-   Added detailed descriptions and examples to the README.md file for better understanding of the library's features and usage.

### Changed

-   Updated the project version in `project.clj` from `0.0.3` to `0.0.4`.
-   Updated the dependency version in `project.clj` from `0.0.1` to `0.0.3`.
-   Updated the README.md file with new sections and links for better documentation and usage instructions.
-   Updated the `fetch` function in `base.clj` to handle more complex queries and parameters, enhancing the library's functionality.

### Removed

-   Removed the `doc/intro.md`, `doc/reference.md`, and `doc/usage.md` files, as they have been consolidated into the docs branch for improved documentation structure.

[0.0.4]: https://github.com/AdaiasMagdiel/deta-clojure/compare/v0.0.3...v0.0.4

## [0.0.5] - 2024-03-14

### Added

- No additions in this version.

### Changed

- Change in the `insert` function in `src/deta/base.clj` to check if the query is a vector instead of a list.
- Fix the fetch function in `src/deta/base.clj` to handle 200 status responses and extract pagination and items information from the JSON response.
- Update of tests in `test/deta/base_test.clj` to reflect changes in the fetch function.
- Library version update to 0.0.5 in `README.md` and `project.clj`.

### Removed

- No removals in this version.

[0.0.5]: https://github.com/AdaiasMagdiel/deta-clojure/compare/v0.0.4...v0.0.5
