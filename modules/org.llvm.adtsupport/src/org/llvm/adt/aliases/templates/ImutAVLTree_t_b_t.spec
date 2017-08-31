FILE_NAME = ImutAVLTreeTypeBoolType
CLASS_SUFFIX = </*typename ImutInfo*/ KeyT, ValT>
AVL_TREE_TYPE = ImutAVLTreeTypeBoolType<KeyT, ValT>
AVL_FACTORY_TYPE = ImutAVLFactoryTypeBoolType<KeyT, ValT>
AVL_GENERIC_ITER_TYPE = ImutAVLTreeGenericIteratorTypeBoolType<KeyT, ValT>
AVL_ORDERED_ITER_TYPE = ImutAVLTreeInOrderIteratorTypeBoolType<KeyT, ValT>
INFO_TYPE = ImutAVLTreeInfoTypeBoolType<KeyT, ValT>
CALLBACL_FUNC_TYPE = Type2Void<ValT>
KEY_TYPE = KeyT
DATA_TYPE = boolean
VALUE_TYPE = ValT
CLONE_VALUE_IMPL = Native.$tryClone(V)