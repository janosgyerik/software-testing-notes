# Unit testing

Common principles, examples, DOs and DONTs.

## Why should you write unit test?

The only sensible way to develop software is to write tests first.

- How do you know your code actually works without running tests?
  + You don't. You need to test. And re-test. Again and again.
- Repeated manual testing is so inconvenient that programmers tend to skip it and just cross fingers and "hope for the best"
- Re-running automated tests is a nobrainer. It's easy, fast, satisfying, and a huge relief.
  + If you have them.

## Automate running the tests

- The complete test suite must be runnable from the command line. Know how to do it.
- Re-run the unit tests on every push.
- Never skip the tests. If the tests are not running, you are unprotected from regressions.

## Adding unit tests in existing/legacy projects

Good opportunities for adding unit tests in existing/legacy projects:

- Found a bug? (Actually this applies in any project.)
  1. Implement a test case that fails because of it.
  2. Implement the fix.
  3. Confirm that the test passes.

- Found a complicated method?
  1. Add unit tests to cover the method 100%
  2. Refactor, re-running the tests to track your progress
  3. Confirm that all tests pass.

## Testing tools in Java

- Testing: JUnit vs TestNG vs others -> use JUnit4
  + JUnit is built into all modern IDEs. 
  + Sure it lacks some advanced features. But the best tests are simple.
    If you need advanced features, your design might be fishy.
  + Use version 4, not 3.

- Mocking: Mockito vs PowerMock -> use Mockito
  + Mockito is simple, easy to use, ergonomic
  + Sure it lacks some advanced features. But the best code is simple.
    If you need advanced features, your design might be fishy.

## Organizing test code in Maven projects

- Test code goes in `src/test/java`
- Test classes should have the same package structure as the classes under test

## Naming

- Classes: test classes should use the same name as the class under test with a `Test` suffix
  + Maven ignores test classes that don't end with `Test`

- Methods: use long, descriptive names, with underscores separating words
  + Yes this conflicts with the JLS naming convention of production code.
    Test code is not production code. It's also not API: test methods
    are only called by the testing framework.

## Examples

See the included Java project (testing-java, import with Maven).
