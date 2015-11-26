# Unit testing

Common principles, examples, DOs and DONTs.

## Why should you write unit test at all?

- How do you know your code actually works without running tests?
  + You don't. You need to test. And re-test. Again and again.

- Repeating manual tests is extremely inconvenient.
  Manual testing leads to skipping some steps due to laziness.
  It's a real hazard, leading to releasing not fully tested code.

- Re-running automated tests is a nobrainer. It's easy, fast, highly satisfying, huge relief, great comfort.

## Why should you write unit tests first before code?

Writing tests first is the only sensible way to develop software.

- By writing tests first, you ensure testability
  + It's typically hard to add tests later

- By writing tests first, you ensure loose coupling
  + Tightly coupled code is hard to test. Writing the tests first precludes tight coupling

## A simple action plan

The following steps are targeted at teams that don't yet have the good habit of writing tests.
The steps are intentionally in a specific order that should be straightforward to follow.
Never skip the tests. If the tests are not running, you are unprotected from regressions.

Baseline: the bare minimum to have sanity

- Setup continuous integration (automated builds, triggered by every commit or push)
- Make sure that tests are executed as part of continuous integration
  + If tests are disabled, enable them. If you cannot enable them because they are broken, then fix them

Next level: create good habits

- Have each team member implement one test. Right now. Code review each other, referencing the examples in this project
- Have each team member implement one test per week. Regularity is crucial.
  + Ensure regularity by designating a testing day, early in the week
- Gamify it: for example, create some sort of dashboard, showing the history of testing activity of your team members, and the test coverage of the project

Next level: test driven development tdd

- The only sane way to develop software
- Guarantees shorter schedules: the time invested in writing the tests is saved many times over through the time you don't have to spend on debugging and painful regressions and bugfix releases
- Guarantees testable code
- Guarantees easier and safer future evolutions

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

The of the examples is to answer questions like:

- What makes a unit test good or bad?
- How to write good tests?
- How to rewrite bad tests to make them good?

See the included Java project (testing-java, import with Maven).

- [x] [The test case should make the causes and effects perfectly clear](testing-java/src/test/java/testing/examples/ClearCauseAndEffect)
- [ ] [Test cases should be simple](testing-java/src/test/java/testing/examples/Simple)
- [ ] [Test cases should be short](testing-java/src/test/java/testing/examples/Short)
- [x] [Test cases should be fast](testing-java/src/test/java/testing/examples/Fast)
- [x] [A test method should test one thing](testing-java/src/test/java/testing/examples/OneTestOneMethod)
- [x] [Don't use numbering in test case names](testing-java/src/test/java/testing/examples/NoNumberedNaming)
- [x] [Test cases should have descriptive names](testing-java/src/test/java/testing/examples/DescriptiveNaming)
- [x] [Test cases should be easy to read and understand](testing-java/src/test/java/testing/examples/EasyToRead)
- [ ] [Test enough interesting cases](testing-java/src/test/java/testing/examples/NotEnoughTesting)
- [ ] [No need to test trivial things](testing-java/src/test/java/testing/examples/NoNeedForTrivial)
- [x] [Remember to test invalid inputs](testing-java/src/test/java/testing/examples/ValidateInput)
- [x] [Try to test all corner cases](testing-java/src/test/java/testing/examples/CornerCases)
- [x] [DRY - don't repeat yourself!](testing-java/src/test/java/testing/examples/DRY)
- [x] [Test expected exceptions](testing-java/src/test/java/testing/examples/ExpectedException)
- [ ] [Test cases should not have side effects](testing-java/src/test/java/testing/examples/NoSideEffects)
- [ ] [Test cases should not rely on external data](testing-java/src/test/java/testing/examples/NoExternalData)
- [x] [Test cases should not rely on the local filesystem](testing-java/src/test/java/testing/examples/NoLocalData)
- [x] [Test cases should not have loops or complex logic](testing-java/src/test/java/testing/examples/NoLooping)
- [x] [Don't print in test cases](testing-java/src/test/java/testing/examples/NoPrinting)
