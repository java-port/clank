public /*inline*/ EventInfo(final EventInfo /*&&*/ $Prm0) {
  // : Checkers(static_cast<EventInfo &&>().Checkers), HasDispatcher(static_cast<EventInfo &&>().HasDispatcher) 
  //START JInit
  this.Checkers = new SmallVector<Check$CheckEventFunc>($Prm0.Checkers);
  this.HasDispatcher = $Prm0.HasDispatcher;
  //END JInit
}

@Override
public EventInfo clone() {
  return new EventInfo(this);
}
