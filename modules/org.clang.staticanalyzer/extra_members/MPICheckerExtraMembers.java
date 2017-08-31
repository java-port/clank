private final CheckBase $CHECKS[] = {
  new PreCall(),
  new DeadSymbols()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
