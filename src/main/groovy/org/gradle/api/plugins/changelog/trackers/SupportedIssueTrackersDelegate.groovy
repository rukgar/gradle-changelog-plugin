package org.gradle.api.plugins.changelog.trackers

import java.util.regex.Pattern

class SupportedIssueTrackersDelegate {

    private List<IssueTracker> issueTrackers

    SupportedIssueTrackersDelegate() {
       this([new GitHubIssueTracker(), new JiraIssueTracker()])
    }

    SupportedIssueTrackersDelegate(List<IssueTracker> issueTrackers) {
        this.issueTrackers = issueTrackers
    }

    Pattern buildIssueNumberRegex() {
        def orSelector = issueTrackers*.getIssuePattern()*.toString().join("|")
        return ~/$orSelector/
    }

    String getIssueUrlPath(String issueNumber) {
        return issueTrackers.find {issueNumber =~ /^${it.getIssuePattern()}$/ }?.getIssueDetailUrlPath() ?: "issue"
    }

}
