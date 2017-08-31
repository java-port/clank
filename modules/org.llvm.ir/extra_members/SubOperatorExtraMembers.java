public static /*inline*/ boolean classof(/*const*/Instruction /*P*/ From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.Sub);
}

public static /*inline*/ boolean classof(/*const*/ConstantExpr /*P*/ From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.Sub);
}

public static boolean classof(Value From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.Sub);
}
