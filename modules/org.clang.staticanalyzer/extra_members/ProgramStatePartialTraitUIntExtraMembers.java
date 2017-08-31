@Override
public Integer $tryCloneData(JavaCleaner $c$, Integer D) {
  // D is const and not destroyable, no need to clone 
  return D;
}
