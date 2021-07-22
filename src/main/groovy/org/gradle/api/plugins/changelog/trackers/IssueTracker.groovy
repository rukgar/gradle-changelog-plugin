package org.gradle.api.plugins.changelog.trackers

import java.util.regex.Pattern

interface IssueTracker {
    Pattern getIssuePattern()
    String getIssueDetailUrlPath()
}