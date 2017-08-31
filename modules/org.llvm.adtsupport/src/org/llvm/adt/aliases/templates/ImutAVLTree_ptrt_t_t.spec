FILE_NAME = ImutAVLTreePtrTypeType
CLASS_SUFFIX = </*typename ImutInfo*/ KeyT, DataT, ValT>
AVL_TREE_TYPE = ImutAVLTreePtrTypeType<KeyT, DataT, ValT>
AVL_FACTORY_TYPE = ImutAVLFactoryPtrTypeType<KeyT, DataT, ValT>
AVL_GENERIC_ITER_TYPE = ImutAVLTreeGenericIteratorPtrTypeType<KeyT, DataT, ValT>
AVL_ORDERED_ITER_TYPE = ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT>
INFO_TYPE = ImutAVLTreeInfoPtrTypeType<KeyT, DataT, ValT>
CALLBACL_FUNC_TYPE = Type2Void<ValT>
KEY_TYPE = KeyT
DATA_TYPE = DataT
VALUE_TYPE = ValT
CLONE_VALUE_IMPL = Native.$tryClone(V)