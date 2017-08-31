private op_iterator_impl(op_iterator_impl other) { this.Node = other.Node; this.Idx = other.Idx; }
public op_iterator_impl clone() { return new op_iterator_impl(this); }
public @Override boolean $eq(Object other) { return $eq((op_iterator_impl) other); }
