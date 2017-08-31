public BugReport(final BugType /*&*/ bt, char$ptr desc, /*const*/ ExplodedNode /*P*/ errornode) {
  this(bt, new StringRef(desc), errornode);
}

public BugReport(final BugType /*&*/ bt, std.string desc, /*const*/ ExplodedNode /*P*/ errornode) {
  this(bt, new StringRef(desc), errornode);
}

public BugReport(final BugType /*&*/ bt, byte[] desc, /*const*/ ExplodedNode /*P*/ errornode) {
  this(bt, new StringRef(desc), errornode);
}
