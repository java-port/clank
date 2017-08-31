FILE_NAME = StdVectorBool
CLASS_SUFFIX =
MAIN_CLASS = std.vectorBool
TYPE = boolean
BOXED_TYPE = Boolean
ARRAY_TYPE = boolean
NEW_ZERO_ARRAY = new$bool(0)
COPY_OF_ARRAY = copyOf$bool
POINTER_TYPE = bool$ptr
POINTER_FACTORY_MTD = create_bool$ptr
REFERENCE_TYPE = bool$ref
REFERENCE_FACTORY_MTD = create_bool$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = bool$iterator<iterator>
GENERIC_ITERATOR = bool$iterator<?>
JAVA_ITERATOR = JavaIteratorBool
NATIVE_CONTAINER = NativeContainerBool
REV_ITERATOR_TYPE = std.reverse_iteratorBool
REV_ITERATOR_INTERFACE = bool$iterator<reverse_iterator>
SET_IMPL = array[(int) idx] = value; return value;
SET_MOVE_IMPL = array[(int) idx] = value; return value;
REF_SET_IMPL = array[index] = value; return value;
DESTROY_RANGE_IMPL = /*Do not need to destroy primitive types*/
DEFAULT_VALUE = false
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return false;
ASSERT_DEFAULT_VALUE=true
SUPPLIER = boolean
RESIZE_WITH_SUPPLIER = // No supplier => no version of resize with supplier
DEFVAL_WITH_SUPPLIER = return defaultValue
USE_OF_SUPPLIER = Supplier
ELEMENT_BOOL_PREDICATE=NativeCallback.Bool2Bool
