package org.gradle.api.plugins.changelog.tasks


import org.gradle.api.plugins.changelog.GitChangelogService
import org.gradle.api.plugins.changelog.exporters.SlackExporterTemplate
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class SlackChangelogTask extends AbstractChangelogTask {

    @Input
    abstract Property<String> getFile()

    @TaskAction
    def changelogSlack() {
        def service = new GitChangelogService(project, new SlackExporterTemplate())
        def targetFile = getFile() ?: (project.changelog.file ?: "slack-message.txt")

        executeChangelog(service, targetFile)
    }

}