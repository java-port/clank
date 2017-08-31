private GlobalVariable() {
  this.ilist_node$Flds = $ilist_node();
}

public static GlobalVariable $CreateSentinel() {
  return User.<GlobalVariable>$new_FixedUses(0, (type$ptr<?> New$Mem)-> new GlobalVariable());
}
