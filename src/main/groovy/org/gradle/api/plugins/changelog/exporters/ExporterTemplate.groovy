package org.gradle.api.plugins.changelog.exporters

interface ExporterTemplate {

    String titleTemplate()
    String headerTemplate()
    String footerTemplate()
    String componentTemplate()
    String versionTemplate()
    String listItemTemplate()
    String patchVersionTemplate()
    String issueTemplate()
    String commitTemplate()

}