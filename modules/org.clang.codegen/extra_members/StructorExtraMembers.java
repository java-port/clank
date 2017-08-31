@Override
public Structor clone() { 
  return new Structor(this.Priority, this.Initializer, this.AssociatedData);
}
