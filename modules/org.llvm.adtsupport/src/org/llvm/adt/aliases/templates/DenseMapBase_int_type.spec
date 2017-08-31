FILE_NAME = DenseMapBaseIntType
CLASS_SUFFIX = <DerivedT, ValueT>
CLASS_SUFFIX_OTHER = <OtherBaseT, ValueT>
PAIR_TYPE = std.pairIntType<ValueT>
RAW_PAIR_TYPE = std.pairIntType
DERIVED_TYPE = DerivedT
KEY_TYPE = int
RAW_KEY_TYPE = int
VALUE_TYPE = ValueT
VALUE_REFERENCE_TYPE = type$ref<ValueT>
VALUE_REFERENCE_TYPE_IMPL = type$ref_IMPL
VALUE_POINTER_TYPE = type$ptr<ValueT>
DENSE_MAP_ITERATOR = DenseMapIteratorIntType<ValueT>
DENSE_MAP_INFO = DenseMapInfoInt
IS_DATA_POINTER_LIKE = (defaultValue == null)
ASSERT_DEFAULT_VALUE=NativeTrace.assertDefaultValue(defaultValue)
ASSERT_INVALID_KEY_VALUE = true
DEFAULT_VALUE_TO_INSERT=(isDataPointerLike() ? null : $tryClone(defaultValue))
