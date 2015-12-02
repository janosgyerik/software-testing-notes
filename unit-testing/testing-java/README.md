# Testing Java

This is a Maven project, demonstrating common bad practices,
and their remedies, when writing unit tests in Java.

The examples are around on this reference implementation:

[`testing.common.ExcelSheetUtils.titleToNumber`](src/test/java/testing/common/ExcelSheetUtils.java)

The example test classes are in the [`testing.examples`](src/test/java/test/examples) package.
They are in sub-packages labeled after the main topic they demonstrate,
and each sub-package contains a `BadTest.java` and `GoodTest.java`. 

## Examples

*(Work in progress: the items not checked are not done yet.)*

- [ ] [The test case should make the causes and effects perfectly clear](src/test/java/testing/examples/ClearCauseAndEffect)
- [ ] [Test cases should be simple](src/test/java/testing/examples/Simple)
- [ ] [Test cases should be short](src/test/java/testing/examples/Short)
- [ ] [Test cases should be fast](src/test/java/testing/examples/Fast)
- [ ] [A test method should test one thing](src/test/java/testing/examples/OneTestOneMethod)
- [ ] [Don't use numbering in test case names](src/test/java/testing/examples/NoNumberedNaming)
- [ ] [Test cases should have descriptive names](src/test/java/testing/examples/DescriptiveNaming)
- [ ] [Test cases should be easy to read and understand](src/test/java/testing/examples/EasyToRead)
- [ ] [Test enough interesting cases](src/test/java/testing/examples/NotEnoughTesting)
- [ ] [No need to test trivial things](src/test/java/testing/examples/NoNeedForTrivial)
- [ ] [Remember to test invalid inputs](src/test/java/testing/examples/ValidateInput)
- [ ] [Try to test all corner cases](src/test/java/testing/examples/CornerCases)
- [ ] [DRY - don't repeat yourself!](src/test/java/testing/examples/DRY)
- [ ] [Test expected exceptions](src/test/java/testing/examples/ExpectedException)
- [ ] [Test cases should not have side effects](src/test/java/testing/examples/NoSideEffects)
- [ ] [Test cases should not rely on external data](src/test/java/testing/examples/NoExternalData)
- [ ] [Test cases should not rely on the local filesystem](src/test/java/testing/examples/NoLocalData)
- [ ] [Test cases should not have loops or complex logic](src/test/java/testing/examples/NoLooping)
- [ ] [Don't print in test cases](src/test/java/testing/examples/NoPrinting)

## Contributing

If you have more ideas to add, please follow the pattern in the existing examples, in particular:

- Create a sub-package in `testing.examples`, with `BadTest.java` and `GoodTest.java`
- Keep the project build
  + Before commit, verify with: `mvn clean test`
  + If a BAD example test fails, mark it `@Ignore` (see for example [`Fast`](src/test/java/testing/examples/Fast))
- Add the example to the list above
  + Insert it at an appropriate location
