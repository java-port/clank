public OrderGlobalInits() {
  this.priority = 0;
  this.lex_order = 0;
}

@Override public OrderGlobalInits $assign(OrderGlobalInits $Prm0) {
  this.priority = $Prm0.priority;
  this.lex_order = $Prm0.lex_order;
  return this;
}

@Override public OrderGlobalInits clone() {
  return new OrderGlobalInits(this);
}
