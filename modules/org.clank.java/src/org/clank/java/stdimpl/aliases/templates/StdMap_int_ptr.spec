FILE_NAME = StdMapIntPtr
CLASS_SUFFIX = <ValueT>
DUAL_CLASS = std.mapIntPtr<ValueT>
PAIR_TYPE = std.pairIntPtr<ValueT>
ITERATOR = iterator<ValueT>
GENERIC_ITERATOR = type$iterator<?, std.pairIntPtr<ValueT>>
KEY_TYPE = Integer
VALUE_TYPE = ValueT
VALUE_REF = type$ref<ValueT>
VALUE_PTR = type$ptr<ValueT>
IS_KEY_POINTER_LIKE = false
IS_DATA_POINTER_LIKE = true
PAIR_FACTORY_METHOD = std.make_pair_int_Ptr
DEFAULT_KEYS_COMPARATOR = Native::$compare_type_int
ASSERT_DEFAULT_VALUE=(defaultValue == null)