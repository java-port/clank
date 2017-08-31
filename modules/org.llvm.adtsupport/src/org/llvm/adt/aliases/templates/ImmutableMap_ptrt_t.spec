FILE_NAME = ImmutableMapPtrType
CLASS_SUFFIX = <KeyT, DataT>
CLASS_TYPE = ImmutableMapPtrType<KeyT, DataT>
PAIR_TYPE = std.pairPtrType<KeyT, DataT>
AVL_TREE_TYPE = ImutAVLTreePtrTypeType<KeyT, DataT, std.pairPtrType<KeyT, DataT>>
AVL_FACTORY_TYPE = ImutAVLFactoryPtrTypeType<KeyT, DataT, std.pairPtrType<KeyT, DataT>>
AVL_VALUE_ITER_TYPE = ImutAVLValueIteratorPtrTypeType<std.pairPtrType<KeyT, DataT>>
KEY_VALUE_INFO = ImutKeyValueInfo$TP$S<KeyT, DataT>
KEY_TYPE = KeyT
DATA_TYPE = DataT
LOOKUP_TYPE = type$ptr<DataT> /*P*/
LOOKUP_RETURN_IMPL = type$ptr$inout<DataT>
CALLBACK_FUNC_TYPE = TypeType2Void<KeyT, DataT>
JAVA_ITERATOR = JavaIterator<std.pairPtrType<KeyT, DataT>>