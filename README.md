This repository belongs to issue https://github.com/cucumber/cucumber-jvm/issues/2296

I'm using a cucumber taks in gradle wich works with module service2 (no references from service2 to another module). But it fails with module service1 which references an api module.

This is the service Tasks (the same in both modules service1 and service2):

task cucumber() {
    dependsOn assemble, testClasses
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = ['--plugin', 'pretty', '--plugin', 'json:build/cucumber.json', '--plugin', 'html:build/cucumber-reports.html', '--glue', 'milesahead', 'src/test/resources']
        }
    }
}


To demonstrate the error run:

```
gradle :micro:service1:cucumber
```

Without module reference it works:
```
gradle :micro:service2:cucumber
```


The Error running  the cucumber task in module service1 is:

```
* What went wrong:
Execution failed for task ':micro:service1:cucumber'.
> Could not resolve all files for configuration ':micro:service1:cucumberRuntime'.
   > Could not resolve project :api.
     Required by:
         project :micro:service1
      > Cannot choose between the following variants of project :api:
          - productionRuntimeClasspath
          - runtimeElements
        All of them match the consumer attributes:
          - Variant 'productionRuntimeClasspath' capability milesahead.aal:api:0.0.1-SNAPSHOT:
              - Unmatched attributes:
                  - Provides org.gradle.dependency.bundling 'external' but the consumer didn't ask for it
                  - Provides org.gradle.libraryelements 'jar' but the consumer didn't ask for it
                  - Provides org.gradle.usage 'java-runtime' but the consumer didn't ask for it
          - Variant 'runtimeElements' capability milesahead.aal:api:0.0.1-SNAPSHOT:
              - Unmatched attributes:
                  - Provides org.gradle.category 'library' but the consumer didn't ask for it
                  - Provides org.gradle.dependency.bundling 'external' but the consumer didn't ask for it
                  - Provides org.gradle.jvm.version '16' but the consumer didn't ask for it
                  - Provides org.gradle.libraryelements 'jar' but the consumer didn't ask for it
                  - Provides org.gradle.usage 'java-runtime' but the consumer didn't ask for it
```
