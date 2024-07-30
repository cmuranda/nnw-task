**Installation**
- This task uses maven and requires Java 17
- There are no special installation instructions apart from installing dependencies using maven
- To run the application, simply run or debug the Main.java file in the 
`nnw.task` package

**Achitecture**
- Question 1 is run from the Main.java file and uses the HighestCommonFactor class which has two methods:
  - The first one that calculates the HCF between 2 integers using recursion.
  - The second method calculates the HCF of an array of integers through determining the HCF of two successive integers in the array
- The bulk of question 2 is evaluated using the AddressManager class. This class has two dependencies; the ObjectMapper for mapping from String to an object and the AddressPrinter which is for formatting the address
- Validation of an Address object is done using the builtin java validation from the `jakarta.validation` package. This was implemented using builtin annotations; `@NotNull and @Pattern` for not null and numerical input validation respectively, and
  the custom made classes in the `nnw.task.validation` package for other class level validations.
