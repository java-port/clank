@Override
public java.util.Iterator<Instruction> iterator() {
  return new JavaIterator<>(begin(), end());
}

public static BasicBlock $createSentinel() {
  return new BasicBlock();
}

private BasicBlock() {
  this.ilist_node$Flds = $ilist_node_with_parent();
  this.InstList = null;
}
