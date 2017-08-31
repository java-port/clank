protected Instruction() {
  this.ilist_node$Flds = $ilist_node_with_parent();
}

public static Instruction $createSentinel() {
  return User.<Instruction>$new_FixedUses(0, (type$ptr<?> New$Mem)-> new Instruction());
}
