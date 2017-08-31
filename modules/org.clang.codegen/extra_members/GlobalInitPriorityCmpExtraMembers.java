public GlobalInitPriorityCmp() { }

@Override
public boolean $less(std_pair.pair<OrderGlobalInits, Function> LHS, std_pair.pair<OrderGlobalInits, Function> RHS) {
  return $call(LHS, RHS);
}
