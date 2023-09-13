# Methods Counter PLugin

**Petr Tsvetkov ([petsvtekov@constructor.university]())**

_A test task for "QodExa: Tool for runtime error analysis in IDE" thesis project_

### Overview

This application is a simple IDEA plugin that implements a single intention --
when caret is pointing at a Kotlin class name IDEA user can run
"Count methods in a class" option to see a dialog window containing the number of methods
inside the Kotlin class.

The plugin is written in Kotlin.

### Project structure

Intention implementation is located
[here](src/main/kotlin/org/petrtsv/methodscounterplugin/CountClassMethods.kt).

### Launch instructions

To launch an IDEA instance with the plugin installed and activated run ` ./gradlew runIde`