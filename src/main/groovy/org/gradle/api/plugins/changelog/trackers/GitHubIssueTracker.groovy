package org.gradle.api.plugins.changelog.trackers

import java.util.regex.Pattern

class GitHubIssueTracker implements IssueTracker {
    @Override
    Pattern getIssuePattern() {
        return ~/\d+/
    }

    @Override
    String getIssueDetailUrlPath() {
        return "issues"
    }
}