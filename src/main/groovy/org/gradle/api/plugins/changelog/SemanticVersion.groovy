package org.gradle.api.plugins.changelog

import java.util.regex.Matcher
import java.util.regex.Pattern

class SemanticVersion {

    private static Pattern versionPattern =
        Pattern.compile("v?(\\d+)\\.(\\d+)\\.(\\d+)(-SNAPSHOT)?",
                        Pattern.CASE_INSENSITIVE)

    private static int MAJOR_GROUP = 1
    private static int MINOR_GROUP = 2
    private static int REVISION_GROUP = 3
    private static int SNAPSHOT_GROUP = 4

    private int major = 0
    private int minor = 0
    private int revision = 0
    private boolean snapshot

    SemanticVersion() {}

    SemanticVersion(final int major, final int minor, final int revision, final boolean snapshot) {
        this.major = major
        this.minor = minor
        this.revision = revision
        this.snapshot = snapshot
    }

    static SemanticVersion of(final String versionString) {
        final Matcher matcher = versionPattern.matcher(versionString)
        if (matcher.matches()) {
            final SemanticVersion semanticVersion = new SemanticVersion()
            semanticVersion.major = Integer.parseInt(matcher.group(MAJOR_GROUP))
            semanticVersion.minor = Integer.parseInt(matcher.group(MINOR_GROUP))
            semanticVersion.revision = Integer.parseInt(matcher.group(REVISION_GROUP))
            semanticVersion.snapshot = matcher.group(SNAPSHOT_GROUP) != null;
            return semanticVersion
        } else {
            throw new IllegalArgumentException("Invalid version string: " + versionString)
        }
    }

    int getMajor() {
        return major
    }

    int getMinor() {
        return minor
    }

    int getRevision() {
        return revision
    }

    boolean isSnapshot() {
        return snapshot
    }

    boolean isComplete() {
        return major + minor + revision > 0
    }

    SemanticVersion withBumpedMajor() {
        return new SemanticVersion(major + 1, 0, 0, snapshot)
    }

    SemanticVersion withBumpedMinor() {
        return new SemanticVersion(major, minor + 1, 0, snapshot)
    }

    SemanticVersion withBumpedRevision() {
        return new SemanticVersion(major, minor, revision + 1, snapshot)
    }

    SemanticVersion withPreviousRevision() {
        return new SemanticVersion(major, minor, revision == 0 ? 0 : revision - 1, snapshot)
    }

    SemanticVersion withSnapshot(final boolean snapshot) {
        return new SemanticVersion(major, minor, revision, snapshot)
    }

    boolean equals(final Object o) {
        if (this == o) {
            return true
        }
        if (!(o instanceof SemanticVersion)) {
            return false
        }

        final SemanticVersion that = (SemanticVersion)
        return Objects.equals(major, that.major) &&
               Objects.equals(minor, that.minor) &&
               Objects.equals(revision, that.revision)
    }

    String toString() {
        final String numbers = String.format("%s.%s.%s", major, minor, revision)
        return snapshot ? numbers + "-SNAPSHOT" : numbers
    }

}
