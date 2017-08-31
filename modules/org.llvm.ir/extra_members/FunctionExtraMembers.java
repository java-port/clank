@Override
public Iterator<BasicBlock> iterator() {
  return new JavaIterator<BasicBlock>(begin(), end());
}

private Function() {    
  this.ilist_node$Flds = $ilist_node();
  this.BasicBlocks = null;
  this.ArgumentList = null; 
}

public static Function CreateSentinel() {
  return /*NEW_EXPR [User::new]*/User.$new((type$ptr<?> New$Mem)-> new Function());
}
