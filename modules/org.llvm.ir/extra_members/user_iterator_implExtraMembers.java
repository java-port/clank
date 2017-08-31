public type$ptr<Use> getUsePtr() {
  return UI.getPtr();
}

public user_iterator_impl(user_iterator_impl<UserTy> $Prm0) {
  this.UI = $Clone($Prm0.UI);
}

@Override
public user_iterator_impl<UserTy> clone() {
  return new user_iterator_impl<UserTy>(this);
}

@Override
public boolean $eq(Object other) {
  return $eq((user_iterator_impl<UserTy>)other);
}

void $assign(user_iterator_impl<UserTy> other) {
  this.UI = $Clone(other.UI);
}

void $assignMove(user_iterator_impl<UserTy> other) {
  this.UI = other.UI;
  other.UI = null;
}