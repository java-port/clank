@Override
public RUN_SKIP clone() {
  return new RUN_SKIP(opcode, block_var_bytepos, block_var_size);
}

@Override
public boolean $less(Object obj) {
  return $less((RUN_SKIP)obj);
}
