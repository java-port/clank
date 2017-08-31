public static /*inline*/ boolean classof(/*const*/Instruction /*P*/ From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.Shl);
}

public static /*inline*/ boolean classof(/*const*/ConstantExpr /*P*/ From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.Shl);
}

public static boolean classof(Value From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.Shl);
}
