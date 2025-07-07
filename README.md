# life-events-client


Client for HMPO Life Events service

## Code generation from Swagger

Generated using [openapi-generator](https://github.com/OpenAPITools/openapi-generator)

### API updates

To update code with updated OpenAPI, [run script](./bin/code-gen.sh)

```
../bin/code-gen.sh
```

`Note : This generates a maven project and changes need to be merged manually to gradle and made sure any manual changes are not overriden`

## Building and publishing the application

### Building the library

The project uses [Gradle](https://gradle.org) as a build tool. It already contains
`./gradlew` wrapper script, so there's no need to install gradle.

To build the project execute the following command:

```bash
  ./gradlew build
```

### Publishing the library
Releases are created on [github](https://github.com/hmcts/life-events-client/releases/new) and are internally available through azure artifacts [hmcts-lib](https://dev.azure.com/hmcts/Artifacts/_artifacts/feed/hmcts-lib) feed

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for details
