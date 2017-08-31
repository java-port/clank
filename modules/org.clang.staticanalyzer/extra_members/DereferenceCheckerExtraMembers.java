EventDispatcher<ImplicitNullDerefEvent> $Dispatcher = new EventDispatcher<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class);

private final CheckBase $CHECKS[] = {
  new Location(),
  new Bind(),
  $Dispatcher
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
