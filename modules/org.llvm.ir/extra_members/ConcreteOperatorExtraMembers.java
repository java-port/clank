public default int Opc() {
  return Impl.Opc(getClass());
}

static class Impl {

  static void registerOpc(Class<? extends ConcreteOperator> cls, int Opc) {
    assert Impl.Opcs.get(cls) == null : "Already registered " + cls.getName() + " in " + ConcreteOperator.class.getName();
    assert ! Impl.Opcs.values().contains(Opc) : "Opc value " + Opc + " already registered for other class";
    Impl.Opcs.put(cls, Opc);
  }

  static int Opc(Class<? extends ConcreteOperator> cls) {
    Integer result = Impl.Opcs.get(cls);
    assert result != null : "Class " + cls + " not registered in " + ConcreteOperator.class.getName();
    return (result == null) ? -1 : result;
  }

  private static Map<Class<? extends ConcreteOperator>, Integer> Opcs = new HashMap<>();
}
