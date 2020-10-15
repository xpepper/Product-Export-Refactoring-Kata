## Code Coverage

```bash
$ mvn clean test jacoco:report
```

results in `target/site/jacoco/index.html`

## Mutation Testing

```bash
mvn clean test -DwithHistory org.pitest:pitest-maven:mutationCoverage
```

result `target/pit-reports/<report_date>/index.html`