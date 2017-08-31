public GlobalAlias() {
  super();
  this.ilist_node$Flds = $ilist_node();
}

public static GlobalAlias createSentinel() {
  return User.<GlobalAlias>$new(0, (type$ptr<?> New$Mem)-> new GlobalAlias());
}