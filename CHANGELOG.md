<a name="v0.1.3"></a>
# v0.1.3 "Electric Lama" (2015/04/14)


## Bug Fixes

* issues ref can be in a oneliner commit message. Several issues can be closed in one message. Supports wider closing wording ([007bb752](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/007bb752))
* line return after each commit in sections without commit links printed ([1a9b1942](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/1a9b1942))
* **GitHubService:** project obj should be passed to service ([cd0b3647](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/cd0b3647))

## Features

* **regexp:** add the refactor tag to the default filter regexp ([e9f2e37f](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/e9f2e37f))
* added suppor of version name with param subtitle ([572d0dd7](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/572d0dd7))
* **build:** add self changelog plugin ([ab8505ca](https://github.com/marcpoppleton/gradle-changelog-plugin/commits/ab8505ca))

## Refactor

* move regexp for isolating fixes in a method
* etracted string templates out methods
* **GitChangelogTask:** separate logic ina service and add unit tests
