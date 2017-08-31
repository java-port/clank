private final CheckBase $CHECKS[] = {
  new PostObjCMessage(),
  new PreObjCMessage(),
  new PreCall(),
  new Location()
};

@Override protected CheckBase[] $getChecks() { return $CHECKS; }
