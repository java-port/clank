@Override
public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
  if ("TraverseConditionalOperator".equals(TraverseMethodName) ||
      "TraverseIfStmt".equals(TraverseMethodName)) {
    return true;
  }
  return false;
}
