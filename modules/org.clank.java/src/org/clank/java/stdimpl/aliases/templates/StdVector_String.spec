FILE_NAME = StdVectorString
CLASS_SUFFIX = 
MAIN_CLASS = std.vectorString
TYPE = std.string
BOXED_TYPE = std.string
ARRAY_TYPE = Object
NEW_ZERO_ARRAY = new std.string[0]
COPY_OF_ARRAY = copyOf$Object
POINTER_TYPE = type$ptr<std.string>
POINTER_FACTORY_MTD = create_type$ptr
REFERENCE_TYPE = type$ref<std.string>
REFERENCE_FACTORY_MTD = create_type$ref
ITERATOR_NAME = iterator
ITERATOR_TYPE = iterator
ITERATOR_INTERFACE = type$iterator<iterator, std.string>
GENERIC_ITERATOR = type$iterator<?, std.string>
JAVA_ITERATOR = JavaIterator
NATIVE_CONTAINER = NativeContainer<std.string>
REV_ITERATOR_TYPE = std.reverse_iterator<std.string>
SET_IMPL = if (defaultValue == null) {array[(int) idx] = value; } else {array[(int) idx] = $tryAssign(array[(int) idx], value, false); } return array[(int) idx];
SET_MOVE_IMPL = if (defaultValue == null) {array[(int) idx] = value; } else {array[(int) idx] = $tryMove(array[(int) idx], value, false); } return array[(int) idx];
REF_SET_IMPL = if (defaultValue == null) {array[index] = value; } else {array[index] = $tryAssign(array[index], value, false); } return array[index];
DESTROY_RANGE_IMPL = \
    for (/*uint*/int i = from; i < to; i++) {\n\
\t\t\tif (defaultValue != null) { \n\
\t\t\t\tNative.destroy(array[(int) i]);\n\
\t\t\t}\n\
\t\t\tarray[(int) i] = null;\n\
\t\t}
DEFAULT_VALUE = null
SB_APPEND_ELEMENT_I=out.append(element).append('\\\\\\\\n')
IS_DATA_POINTER_LIKE_IMPL=return defaultValue == null;
ASSERT_DEFAULT_VALUE=NativeTrace.assertDefaultValue(defaultValue)
SUPPLIER = std.string
RESIZE_WITH_SUPPLIER = // No supplier => no version of resize with supplier
DEFVAL_WITH_SUPPLIER = return defaultValue
USE_OF_SUPPLIER = Supplier
ELEMENT_BOOL_PREDICATE=NativeCallback.BoolPredicate<std.string>
