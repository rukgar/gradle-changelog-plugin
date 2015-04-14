# Gradle Changelog Plugin

A Gradle plugin which writes a markdown formatted changelog file based on conventional changelog syntax git commits.

## Conventional Changelog

Conventional Changelog is a commit convention defined and used by AngularJS. It aims at producing more usefull changelogs trimming unimportant commits out of the changelog.
For this purpose a set of simple and easy to use conventions are used. The full commit convention can be read [here](https://docs.google.com/document/d/1QrDFcIiPjSLDn3EL15IJygNPiHORgU1_OOAqWjiDU5Y/ "AngularJS Git Commit Message Conventions")

## Basic Usage

Add the plugin to your `buildscript`'s `dependencies` section:

```groovy
classpath 'com.github.marcpoppleton:git-changelog:0.1.3'
```

Apply the `changelog` plugin:

```groovy
apply plugin: 'changelog'
```

Commit using the conventional changelog convention and call the `changelog` Gradle task!

## Configuration

Configuration of the `changelog` task is optionnal, if none is provided the defaults settings will be used. Default values are detailed below.

```groovy
changelog {
    //the name of the file where to write the changelog.
    file “CHANGELOG.md” //Defaults to "CHANGELOG.md"
    
    //the name of the app/project for which you are generating a changelog.
    appName “gradle-changelog-plugin” //Defaults to an empty string.
    
    //version number for this changelog
    versionNum “0.1.3” //Defaults to an empty string.
    
    //version name
    versionText ”Electric Lama” //Defaults to an empty string.
    
    //URL of the repository where the commits can be found. Plugin will append /commits at the end.    
    repoUrl ”https://github.com/marcpoppleton/gradle-changelog-plugin“ //Defaults to an empty string.
    
    //URL of the bug tracker where closed issues can be found. Plugin will append /issues at the end.
    trackerUrl ”https://github.com/marcpoppleton/gradle-changelog-plugin“ //Defaults to an empty string.
    
    //lower limit to filter the git log command
    from “0.0.1“ //Defaults to previous git tag found or first commit if none found.
    
    //upper limito filter the git log command.
    to “HEAD” //Defaults to HEAD.
    
    //regex used to filter the conventional changelog commits for this changelog
    match ”^fix|^feat|^fix|^perf|^refactor|BREAKING” //Defaults to the value in the example.
} 
```



## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

## Changelog

<a name="v0.1.3"></a>
## v0.1.3 "Electric Lama" (2015/04/14)


#### Bug Fixes

* issues ref can be in a oneliner commit message. Several issues can be closed in one message. Supports wider closing wording ([007bb752](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/007bb752))
* line return after each commit in sections without commit links printed ([1a9b1942](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/1a9b1942))
* **GitHubService:** project obj should be passed to service ([cd0b3647](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/cd0b3647))

#### Features

* **regexp:** add the refactor tag to the default filter regexp ([e9f2e37f](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/e9f2e37f))
* added suppor of version name with param subtitle ([572d0dd7](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/572d0dd7))
* **build:** add self changelog plugin ([ab8505ca](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/ab8505ca))

#### Refactor

* move regexp for isolating fixes in a method
* etracted string templates out methods
* **GitChangelogTask:** separate logic ina service and add unit tests