public static /*inline*/ boolean classof(/*const*/Instruction /*P*/ From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.UDiv);
}

public static /*inline*/ boolean classof(/*const*/ConstantExpr /*P*/ From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.UDiv);
}

public static boolean classof(Value From) {
  return ConcreteOperator.classof(From, Instruction.BinaryOps.UDiv);
}
