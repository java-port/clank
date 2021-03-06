FILE_NAME = ImutAVLTree
CLASS_SUFFIX = </*typename ImutInfo*/ KeyT, DataT, ValT>
AVL_TREE_TYPE = ImutAVLTree<KeyT, DataT, ValT>
AVL_FACTORY_TYPE = ImutAVLFactory<KeyT, DataT, ValT>
AVL_GENERIC_ITER_TYPE = ImutAVLTreeGenericIterator<KeyT, DataT, ValT>
AVL_ORDERED_ITER_TYPE = ImutAVLTreeInOrderIterator<KeyT, DataT, ValT>
INFO_TYPE = ImutAVLTreeInfo<KeyT, DataT, ValT>
CALLBACL_FUNC_TYPE = Type2Void<ValT>
KEY_TYPE = KeyT
DATA_TYPE = DataT
VALUE_TYPE = ValT
CLONE_VALUE_IMPL = Native.$tryClone(V)