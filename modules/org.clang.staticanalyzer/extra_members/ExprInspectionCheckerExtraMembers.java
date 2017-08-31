private final CheckBase $CHECKS[] = {
  new eval.Call(),
  new DeadSymbols()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
