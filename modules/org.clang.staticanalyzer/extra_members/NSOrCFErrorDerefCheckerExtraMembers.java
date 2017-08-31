private final CheckBase $CHECKS[] = {
  new Location(),
  new Event<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class)
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
