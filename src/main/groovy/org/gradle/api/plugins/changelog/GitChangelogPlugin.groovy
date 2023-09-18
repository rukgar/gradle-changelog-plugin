package org.gradle.api.plugins.changelog

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.plugins.changelog.tasks.GitChangelogTask
import org.gradle.api.plugins.changelog.tasks.SlackChangelogTask


class ChangelogPluginExtension {
    String appName
    String file
    String trackerUrl
    String versionNum
    String match
    String repoUrl
    String versionText
    String from
    String to
    String append
}

class GitChangelogPlugin implements Plugin<Project> {
    void apply(Project project) {
        def extension = project.extensions.create('changelog', ChangelogPluginExtension)
        project.task('changelog', type: GitChangelogTask)
        project.task('changelogSlack', type: SlackChangelogTask)
    }
}
