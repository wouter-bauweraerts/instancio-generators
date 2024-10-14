# Instancio Generators

[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-orange.svg)](https://sonarcloud.io/summary/new_code?id=wouter-bauweraerts_instancio-generators)

## Description
When using [Instancio](https://www.instancio.org/), you often find yourself writing the same generation rules over and over again.
With this project, we'll try to prevent this as much as possible, 
by providing [custom generators](https://www.instancio.org/user-guide/#custom-generators) that can be used with [Instancio](https://www.instancio.org/)

## Generators provided
### Phone
Phone number generators for landline and mobile phone numbers in both national and international formats.
Currently, we support generation for the following countries:
- Belgium
- The Netherlands

Some other countries are planned to be implemented. Check the [Issues page](https://github.com/wouter-bauweraerts/instancio-generators/issues) for an up-to-date overview of the issues that are planned.
Do you need support for another country? Feel free to create a new issue, providing sufficient details about the number format for landline and mobile phones.
Data required:
- Country name + abbreviation
- Country code (international number prefix)
- landline number format
    - How many numbers are possible. For some countries the areacode varies in length. Very often the first group also varies, because the total character count should be fixed.
    - how should the result (```String```) be formatted?
- Are there any numbers that should be fixed. 
  Eg.: Belgian mobile phones start with 04xx, Dutch mobile phones start with 06

## Contributor info
We would like to provide a fluent api, similar to how [Instancio](https://www.instancio.org/) works itself with the generators.
To achieve this, each supported feature should be added in the ```Generators``` class with a static method.

### Package structure
The ```Generators``` class is situated in the root package (```io.github.wouterbauweraerts.instancio.generators```).
All features should have their own package. 
Eg.: Everything belonging to the ```Phone``` feature lives within the ```io.github.wouterbauweraerts.instancio.generators.phone``` package or a subpackage.

Follow this structure in additional features.
## Status
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=wouter-bauweraerts_instancio-generators&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=wouter-bauweraerts_instancio-generators)
