public df_iterator_storage() {
}

public df_iterator_storage(SetType Visited) {
  this.Visited = Visited;
}

public df_iterator_storage(df_iterator_storage<SetType> other) {
  this.Visited = $tryClone(other.Visited);
}

