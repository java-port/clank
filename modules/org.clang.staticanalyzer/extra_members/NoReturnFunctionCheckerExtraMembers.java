private final CheckBase $CHECKS[] = {
  new PostCall(),
  new PostObjCMessage()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
