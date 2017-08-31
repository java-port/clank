@Override
public BlockNode clone() {
  return new BlockNode(this);
}

@Override
public int compareTo(BlockNode o) {
  if (this.$less(o)) {
    return -1;
  } else if (this.$greater(o)) {
    return 1;
  }
  return 0;
}
