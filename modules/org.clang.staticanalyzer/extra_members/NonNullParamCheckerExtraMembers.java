EventDispatcher<ImplicitNullDerefEvent> $Dispatcher = new EventDispatcher<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class);

private final CheckBase $CHECKS[] = {
  new PreCall(),
  $Dispatcher
};

@Override
protected CheckBase[] $getChecks() {
  return $CHECKS;
}
