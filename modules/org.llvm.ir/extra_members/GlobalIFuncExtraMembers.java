private GlobalIFunc() {
  this.ilist_node$Flds = $ilist_node();
}

public static GlobalIFunc createSentinel() {
  return User.<GlobalIFunc>$new(0, (type$ptr<?> New$Mem)-> new GlobalIFunc());
}