package org.gradle.api.plugins.changelog.exporters

class MarkdownExporterTemplate implements ExporterTemplate {

    @Override
    String titleTemplate() {
        return '\n## <%= title %>\n\n'
    }

    @Override
    String headerTemplate() {
        return '<a name="<%= version %>"></a>\\n<%= versionText %> (<%= date %>)\n\n'
    }

    @Override
    String footerTemplate() {
        return '\n'
    }

    @Override
    String componentTemplate() {
        return '* **<%= name %>:**'
    }

    @Override
    String versionTemplate() {
        return '## <%= version %><%= subtitle ? (" " + subtitle) : "" %>'
    }

    @Override
    String listItemTemplate() {
        return '<%= prefix %> <%= commitSubject %> (<%= commitLink %><%= closes ? (", closes " + closes) : "" %>)\n'
    }

    @Override
    String patchVersionTemplate() {
        return '# <%= version %><%= subtitle ? (" " + subtitle) : "" %>'
    }

    @Override
    String issueTemplate() {
        return '${repository ? "[#$issue]($repository/$path/$issue)" : "#$issue"}'
    }

    @Override
    String commitTemplate() {
        return '${repository ? "[$commit]($repository/commits/$commit)" : "#$commit"}'
    }

}