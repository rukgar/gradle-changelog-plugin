# Gradle Changelog Plugin

A Gradle plugin which writes a markdown formatted changelog file based on conventional changelog syntax git commits.

## Conventional Changelog

Conventional Changelog is a commit convention defined and used by AngularJS. It aims at producing more usefull changelogs trimming unimportant commits out of the changelog.
For this purpose a set of simple and easy to use conventions are used. The full commit convention can be read [here](https://docs.google.com/document/d/1QrDFcIiPjSLDn3EL15IJygNPiHORgU1_OOAqWjiDU5Y/ "AngularJS Git Commit Message Conventions")

## Basic Usage

Apply the `changelog` plugin to your plugins block

```groovy
plugins {
    id 'com.geoffgranum.gradle-conventional-changelog' version '0.3.1'
}
```

1) Commit one or more commits using the conventional changelog [convention](https://docs.google.com/document/d/1QrDFcIiPjSLDn3EL15IJygNPiHORgU1_OOAqWjiDU5Y)
2) Update your project's version number.
2) Run the `./gradlew changelog` task.
3) Review and correct your changelog file (usually CHANGELOG.MD)
4) Commit your modified changelog file with a 'chore' commit message. For example:
    * `git add . && git commit -m "chore(changelog): Update changelog"`
5) Tag your build with the correct version (from step 2): 
    * `git tag -a "v0.3.1.RC1 -F CHANGELOG.MD` ( -F copies tag message from specified file)
6) Push your changed branch and the tag
    * `git push && git push origin --tags`    

## Configuration

Configuration of the `changelog` task is optional, if none is provided the defaults settings will be used. Default values are detailed below.

```groovy
changelog {
    //the name of the file where to write the changelog.
    file 'CHANGELOG.md' //Defaults to "CHANGELOG.md"
    
    //the name of the app/project for which you are generating a changelog.
    appName 'gradle-changelog-plugin' //Defaults to an empty string.
    
    //version number for this changelog
    versionNum '0.1.3'//Guesses next version using commits content and defaults to an empty string.
    
    //version name
    versionText 'Electric Lama' //Defaults to an empty string.
    
    //URL of the repository where the commits can be found. Plugin will append /commits at the end.    
    repoUrl 'https://github.com/marcpoppleton/gradle-changelog-plugin' //Defaults to an empty string.
    
    //URL of the bug tracker where closed issues can be found. Plugin will append /issues at the end.
    trackerUrl 'https://github.com/marcpoppleton/gradle-changelog-plugin' //Defaults to an empty string.
    
    //lower limit to filter the git log command ( tag or commit hash)
    from '0.0.1' //Defaults to previous git tag found or first commit if none found.
    
    //upper limit filter the git log command.
    to 'HEAD' //Defaults to HEAD.
    
    //regex used to filter the conventional changelog commits for this changelog
    match '^fix|^feat|^fix|^perf|^refactor|BREAKING' //Defaults to the value in the example.
} 
```
