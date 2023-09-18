package org.gradle.api.plugins.changelog.exporters

class SlackExporterTemplate implements ExporterTemplate {

    @Override
    String titleTemplate() {
        return '\n *<%= title %>*\n'
    }

    @Override
    String headerTemplate() {
        return '*<%= versionText %> (_<%= date %>_)*\n\n'
    }

    @Override
    String footerTemplate() {
        return '\n'
    }

    @Override
    String componentTemplate() {
        return '\t* *<%= name %>:*'
    }

    @Override
    String versionTemplate() {
        return ' *<%= version %><%= subtitle ? (" _" + subtitle + "_") : "" %>*'
    }

    @Override
    String listItemTemplate() {
        return '<%= prefix %> <%= commitSubject %> (<%= commitLink %><%= closes ? (", closes " + closes) : "" %>)\n'
    }

    @Override
    String patchVersionTemplate() {
        return ' *<%= version %><%= subtitle ? (" _" + subtitle + "_") : "" %>*'
    }

    @Override
    String issueTemplate() {
        return '${repository ? "<$repository/$path/$issue|#$issue>" : "#$issue"}'
    }

    @Override
    String commitTemplate() {
        return '${repository ? "<$repository/commits/$commit|$commit>" : "#$commit"}'
    }

}
