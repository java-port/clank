public static ForcePassLinking getInstance(){
  ArrayList<ForcePassLinking> list = new ArrayList(Lookup.getDefault().lookupAll(ForcePassLinking.class));
  ForcePassLinking main = list.remove(0);
  return main.create(list);
}
public abstract ForcePassLinking create(List<ForcePassLinking> services);
public abstract void create();
public abstract void create(raw_string_ostream os);
public abstract void create2();
