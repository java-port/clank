private final CheckBase $CHECKS[] = {
  new PostCall(),
  new PreCall(),
  new DeadSymbols(),
  new PointerEscape()
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
