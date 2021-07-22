package org.gradle.api.plugins.changelog.trackers

import java.util.regex.Pattern

class JiraIssueTracker implements IssueTracker {
    @Override
    Pattern getIssuePattern() {
        return ~/[A-Z]+-\d+/
    }

    @Override
    String getIssueDetailUrlPath() {
        return "browse"
    }
}