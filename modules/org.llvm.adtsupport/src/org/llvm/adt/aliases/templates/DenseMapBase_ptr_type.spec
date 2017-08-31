FILE_NAME = DenseMapBasePtrType
CLASS_SUFFIX = <DerivedT, KeyT, ValueT>
CLASS_SUFFIX_OTHER = <OtherBaseT, KeyT, ValueT>
PAIR_TYPE = std.pairPtrType<KeyT, ValueT>
RAW_PAIR_TYPE = std.pairPtrType
DERIVED_TYPE = DerivedT
KEY_TYPE = KeyT
RAW_KEY_TYPE = Object
VALUE_TYPE = ValueT
VALUE_REFERENCE_TYPE = type$ref<ValueT>
VALUE_REFERENCE_TYPE_IMPL = type$ref_IMPL
VALUE_POINTER_TYPE = type$ptr<ValueT>
DENSE_MAP_ITERATOR = DenseMapIteratorPtrType<KeyT, ValueT>
DENSE_MAP_INFO = DenseMapInfo<KeyT>
IS_DATA_POINTER_LIKE = false
ASSERT_DEFAULT_VALUE=(defaultValue != null) && NativeTrace.assertDefaultValue(defaultValue)
ASSERT_INVALID_KEY_VALUE = (this.emptyKey != null) && (this.tombstoneKey != null)
DEFAULT_VALUE_TO_INSERT=(ValueT)$Clone((NativeCloneable)defaultValue)
