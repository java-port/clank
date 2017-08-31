@FunctionalInterface
public static interface NormalCtor_t {
  Pass $call();
}

@FunctionalInterface
public static interface TargetMachineCtor_t {
  Pass $call(TargetMachineForward targetMachine);
}

private final/*const*/Class<? extends Pass>/*void P*/ PassID;
