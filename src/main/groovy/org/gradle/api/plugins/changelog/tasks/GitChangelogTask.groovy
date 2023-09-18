package org.gradle.api.plugins.changelog.tasks


import org.gradle.api.plugins.changelog.GitChangelogService
import org.gradle.api.plugins.changelog.exporters.MarkdownExporterTemplate
import org.gradle.api.tasks.TaskAction

class GitChangelogTask extends AbstractChangelogTask {
    @TaskAction
    def changelog() {
        def service = new GitChangelogService(project, new MarkdownExporterTemplate())
        def targetFile = project.changelog.file ? project.changelog.file : "CHANGELOG.md"

        executeChangelog(service, targetFile)
    }

}